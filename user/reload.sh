#!/bin/sh
# logger信息
LOGGER=/Users/fanhehe/workspace/github/SpringBoot/user/log
# 项目名称
PROJECT_NAME=user.jar
# java 配置
JAVA_OPTS='-Xms128m -Xmx512m -XX:NewSize=128m -XX:MaxNewSize=512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m -XX:NewRatio=2 -XX:MaxTenuringThreshold=8 -XX:+DisableExplicitGC'

# 如果无法关闭的最大的重试次数
MAX_TIMEOUT=30

# 修改进程的工作路径为项目路径
if [ -L $0 ]
then
    _RELATIVE_PATH=`dirname $(readlink $0)`
else
    _RELATIVE_PATH=`dirname $0`
fi

cd $_RELATIVE_PATH

# 获取当前项目的pid
get_project_pid () {
    eval "$1=`ps aux | grep $PROJECT_NAME | grep -v grep | grep -v kill | awk '{print $2}'`"
}

# 进程PID
PID=

get_project_pid PID

#if [ ${PID} ]; then
#    echo 'Stop Process...'
#    kill -15 $PID
#fi

# 关闭程序,带重试30次的
for((i=0; i<$MAX_TIMEOUT; i++))
do
    sleep 1
    get_project_pid PID
    if [ ${PID} ]; then
        echo 'App Stopping...'
    else
        break
    fi
done

# 强关程序
if [ ${PID} ]; then
    echo 'Kill Process!'
    kill -9 $PID
else
    echo 'Stop Success!'
fi

get_project_pid PID

if [ ${PID} ]; then
    echo 'App is running.'
else
    echo 'App is NOT running.'
fi

rm -f PID

# maven 重新打包
mvn clean && mvn package -Dmaven.test.skip=true

# 运行程序
nohup java -jar $JAVA_OPTS target/${PROJECT_NAME} 2>&1 1>$LOGGER &

# 将pid写进文件中
#echo $! > PID
echo Start Success!