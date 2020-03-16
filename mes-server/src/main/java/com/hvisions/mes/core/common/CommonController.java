package com.hvisions.mes.core.common;

import com.hvisions.mes.core.jdpush.JdPush;
import com.hvisions.mes.core.util.RedisUtils;
import com.hvisions.mes.dict.dao.DictMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 公共接口
 * @author: Bruce
 * @version:
 * @date: 2019-11-11 13:21
 */
@RestController
@RequestMapping(value = "/comm")
@Api(description = "公共接口控制器")
public class CommonController {

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "查询数据字典")
    @GetMapping("/dict/{typeCode}")
    @ApiImplicitParam(name = "typeCode", value = "leak_type(泄漏类型), c_index_unit(消耗指标单位)", paramType = "path", required = false, defaultValue = "", dataType = "String")
    public Object dict(@PathVariable String typeCode) {
        Object str = redisUtils.get(typeCode);
        if (null == str) {
            str = JSONArray.fromObject(dictMapper.findByType(typeCode));
            redisUtils.set(typeCode, str);
        }
        return str;
    }

    @ApiOperation(value = "查询车间")
    @GetMapping("/findPlant/{plantId}")
    @ApiImplicitParam(name = "plantId", value = "工厂id", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public List<Map<String, Object>> findPlant(@PathVariable int plantId) {
        return dictMapper.findPlantByParentId(plantId);
    }

    @ApiOperation(value = "查询产线")
    @GetMapping("/findProdLine")
    public List<Map<String, Object>> findPlant() {
        return dictMapper.findProdLine("产线");
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/findAllUser")
    public List<Map<String, Object>> findAllUser() {
        return dictMapper.findAllUser();
    }

    @ApiOperation(value = "根据车间编号查询下面所有的设备")
    @GetMapping("/findEquipment/{plantCode}")
    @ApiImplicitParam(name = "plantCode", value = "车间编号", paramType = "path", required = false, defaultValue = "", dataType = "string")
    public List<Map<String, Object>> findEquipment(@PathVariable String plantCode) {
        return dictMapper.findEquipmentByPlantCode(plantCode);
    }

    @ApiOperation(value = "极光推送")
    @PostMapping("/jdpush")
    public void pushMessage() {
        Map<String, String> parm =new HashMap<String, String>();
        //这是我的文章id
        parm.put("id", "123");
        //文章标题
        parm.put("Atitle", "test" );
        //设置提示信息,内容是文章标题
        parm.put("msg", "test123" );
        //调用ios的
        JdPush.jpushIOS(parm);
        //然后调用安卓的
        JdPush.jpushAndroid(parm);

    }
}
