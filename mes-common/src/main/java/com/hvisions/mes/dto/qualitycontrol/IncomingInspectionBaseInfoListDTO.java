package com.hvisions.mes.dto.qualitycontrol;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/18
 * Version:  1.0.0
 */
public class IncomingInspectionBaseInfoListDTO implements Serializable {

    private Integer id;

    private Integer cargoId;

    private String cargoName;

    private String supplier;

    private String source;

    private String manufacturer;

    private String cargoNumber;

    private String cargoSpec;

    private String supplierBatchNumber;

    private Date prodDateStart;

    private Date prodDateEnd;




}
