package com.fanhehe.neckpets.business.wave.pojo.bo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/15 08:20
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WaveNumber implements Serializable {
    private Long userId;
    private Long number;
}
