package com.hvisions.mes.postleak.controller;

import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.dto.postleak.PostLeakListDTO;
import com.hvisions.mes.dto.postleak.SavePostLeakInfoDTO;
import com.hvisions.mes.dto.postleak.SavePostLeakLogDTO;
import com.hvisions.mes.dto.postleak.SearchPostLeakDTO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.postleak.service.PostLeakService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 岗位漏点控制器
 * @author: Bruce
 * @version:
 * @date: 2019-11-05 10:52
 */
@RestController
@RequestMapping(value = "/postLeak")
@Api(description = "岗位漏点控制器")
public class PostLeakController extends BaseController {

    @Autowired
    private PostLeakService postLeakService;

    @ApiOperation(value = "新增", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SavePostLeakInfoDTO dto) {
        return postLeakService.save(dto, getCurrentUser());
    }

    @ApiOperation(value = "删除", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public int delete(@PathVariable("id") int id) {
        return postLeakService.delete(id, getCurrentUser());
    }

    @ApiOperation(value = "列表", response = PostLeakListDTO.class)
    @PostMapping("/list")
    public Page<PostLeakListDTO> list(@RequestBody SearchPostLeakDTO dto) {
        return postLeakService.list(dto);
    }

    @ApiOperation(value = "修改", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody SavePostLeakInfoDTO dto) {
        return postLeakService.update(dto, getCurrentUser());
    }

    @ApiOperation(value = "处理情况", response = ResultVO.class)
    @PostMapping("/dispose")
    public int dispose(@RequestBody SavePostLeakLogDTO dto) {
        return postLeakService.dispose(dto, getCurrentUser());
    }

    @ApiOperation(value = "复核确认", response = ResultVO.class)
    @PutMapping("/review/{id}/{backup}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer"),
        @ApiImplicitParam(name = "backup", value = "备注", paramType = "path", required = false, defaultValue = "null", dataType = "Integer")
    })
    public int review(@PathVariable("id") int id, @PathVariable("backup") String backup) {
        return postLeakService.review(id, getCurrentUser(), backup);
    }
}
