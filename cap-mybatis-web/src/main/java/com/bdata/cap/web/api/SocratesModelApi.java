package com.bdata.cap.web.api;

//import com.jd.common.web.LoginContext;
//import com.jd.fastjson.JSONObject;
//import com.jd.jr.cupid.model.admin.core.dao.model.SocratesModel;
//import com.jd.jr.cupid.model.admin.core.dao.model.SocratesModelRankUpHandshake;
//import com.jd.jr.cupid.model.admin.core.enums.SocratesModelStateType;
//import com.jd.jr.cupid.model.admin.core.enums.SocratesModelUpdateType;
//import com.jd.jr.cupid.model.admin.core.enums.SocratesStateCode;
//import com.jd.jr.cupid.model.admin.core.vo.*;
//import com.jd.jr.cupid.model.admin.web.response.SuAjaxVoResult;
//import com.jd.jr.cupid.model.admin.web.util.GsonUtil;
//import com.bdata.cap.web.api.base.SocratesModelApiBase2;
//import com.jd.jr.socrates.model.predict.api.vo.PredictResult;
//import com.jd.jr.socrates.model.predict.api.vo.Response;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模型定义api
 *
 * @author liuning11@jd.com
 * @date 2019-04-17 18:36
 **/
@Slf4j
@RestController
@RequestMapping("/api/socrates/model")
public class SocratesModelApi {
//
//    /**
//     * 检索
//     */
//    @GetMapping("/qm")
//    public SuAjaxVoResult queryModel(SocratesModelQueryVo vo) {
//        SocratesModel model = vo.build();
//        Map<String, Object> result = socratesModelService.get(model,
//                vo.getPageNum(), vo.getPageSize(),
//                vo.getBeginTime(), vo.getEndTime());
//
//        return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), result);
//    }
//
//    /**
//     * 检索
//     */
//    @GetMapping("/q")
//    public SuAjaxVoResult query(SocratesModelIpAddrCurrentStateQueryVo vo) {
//        SocratesModel socratesModel = vo.build();
//        Map<String, Object> result = socratesModelIpAddrCurrentStateService.getPager(socratesModel,
//                vo.getAction(),
//                vo.getPageNum(),
//                vo.getPageSize(),
//                vo.getBeginTime(),
//                vo.getEndTime());
//
//        return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), result);
//    }
//
//    /**
//     * 检索
//     */
//    @GetMapping("/get")
//    public SuAjaxVoResult getBy(Integer id) {
//        SocratesModel socratesModel = socratesModelService.getByID(id);
//        if (socratesModel != null) {
//            return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), socratesModel);
//        }
//        return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), null);
//    }
//
//    /**
//     * @param modelFile
//     * @param featFile
//     * @param name
//     * @param modelDescription
//     * @param modelRepType
//     * @param modelType
//     * @param modelAlType
//     * @param request
//     * @return
//     * @throws IOException
//     */
//    @PostMapping(value = "/add")
//    public SuAjaxVoResult add(@RequestParam MultipartFile modelFile,
//                              @RequestParam MultipartFile featFile,
//                              @RequestParam String name,
//                              @RequestParam String modelDescription,
//                              @RequestParam String modelRepType,
//                              @RequestParam String modelType,
//                              @RequestParam String modelAlType,
//                              HttpServletRequest request) {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//        //
//        try {
//            SocratesModel model = SocratesModel.buildCreate(name, modelDescription,
//                    modelRepType, modelType, modelAlType, SocratesModelStateType.ONLINE,
//                    user_pin, nick_name, email, null);
//            Integer survivalTime = -1;
//            boolean bl = socratesModelService.createModel(model);
//            if (bl) {
//                boolean isSuccessUploadModelFile = uploadModelFile(modelFile, survivalTime, model);
//                boolean isSuccessUploadFeatFile = uploadFeat(featFile, model);
//                boolean isSuccessUpdateModelPath = socratesModelService.updateVersionBy(
//                        model.getId(),
//                        model.getModelVersion(),
//                        model.getModelPath(),
//                        model.getModelPathLocal());
//
//                // temp
//                SocratesModel m = socratesModelService.getByID(model.getId());
//                m.setModelMergeState(this.convertMergeState(m.getModelState(), SocratesModelUpdateType.UNKNOWN.getMessage()));
//                if (model != null) {
//                    zkRankUpWaveWriteService.online(m);
//                    return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), m);
//                }
//
//                return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), m);
//            }
//
//            return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), null);
//        } catch (Exception ex) {
//            return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), null);
//        }
//    }
//
//    /**
//     * @param modelFile
//     * @param featFile
//     * @param name
//     * @param modelDescription
//     * @param request
//     * @return
//     */
//    @PostMapping("/update")
//    public SuAjaxVoResult update(@RequestParam Integer id,
//                                 @RequestParam(required = false) MultipartFile modelFile,
//                                 @RequestParam(required = false) MultipartFile featFile,
//                                 @RequestParam(required = false) String name,
//                                 @RequestParam(required = false) String modelDescription,
//                                 HttpServletRequest request) throws IOException {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//        //
//        SocratesModel socratesModel = SocratesModel.buildUpdate(id, name, modelDescription,
//                user_pin, nick_name, email, null);
//        //
//        boolean isUploadModel = uploadModelFile(modelFile, -1, socratesModel);
//        boolean isUploadFeat = uploadFeat(featFile, socratesModel);
//        boolean bl = socratesModelService.update(socratesModel);
//        SocratesModel model = socratesModelService.getByID(id);
//        //
//        if (isUploadModel) {
//            model.setModelPath(socratesModel.getModelPath());
//            model.setModelPathLocal(socratesModel.getModelPathLocal());
//            model.setModelVersion(socratesModel.getModelVersion());
//            model.setFeatVersion(socratesModel.getFeatVersion());
//            model.setModelMergeState(this.convertMergeState(model.getModelState(), SocratesModelUpdateType.UNKNOWN.getMessage()));
//            zkRankUpWaveWriteService.update(model);
//        }
//
//        if (bl) {
//            return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), model);
//        }
//        return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), model);
//    }
//
//    /**
//     * Model Online
//     *
//     * @param vo
//     * @param request
//     * @return
//     */
//    @PostMapping("/online")
//    public SuAjaxVoResult online(@RequestBody SocratesModelIdVo vo, HttpServletRequest request) {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//
//        boolean bl = socratesModelService.online(vo.getId(), user_pin, nick_name, email);
//        if (bl) {
//            //
//            SocratesModel model = socratesModelService.getByID(vo.getId());
//            if (model != null) {
//                model.setModelMergeState(this.convertMergeState(model.getModelState(), SocratesModelUpdateType.UNKNOWN.getMessage()));
//                zkRankUpWaveWriteService.online(model);
//                return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), bl);
//            } else {
//                return new SuAjaxVoResult(SocratesStateCode.EMPTY.getCode(), SocratesStateCode.EMPTY.getMessage(), null);
//            }
//        }
//        return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), bl);
//    }
//
//    /**
//     * Model Offline
//     *
//     * @param vo
//     * @param request
//     * @return
//     */
//    @PostMapping("/offline")
//    public SuAjaxVoResult offline(@RequestBody SocratesModelIdVo vo, HttpServletRequest request) {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//
//        boolean bl = socratesModelService.offline(vo.getId(), user_pin, nick_name, email);
//        if (bl) {
//            //
//            SocratesModel model = socratesModelService.getByID(vo.getId());
//            if (model != null) {
//                model.setModelMergeState(this.convertMergeState(model.getModelState(), SocratesModelUpdateType.UNKNOWN.getMessage()));
//                zkRankUpWaveWriteService.offline(model);
//                return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), bl);
//            } else {
//                return new SuAjaxVoResult(SocratesStateCode.EMPTY.getCode(), SocratesStateCode.EMPTY.getMessage(), null);
//            }
//        }
//        return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), null);
//    }
//
//    /**
//     * @param vo
//     * @return
//     */
//    @GetMapping("/qrollback")
//    public SuAjaxVoResult rollbackQuery(SocratesModelIdTopNVo vo) {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//
//        SocratesModel socratesModel = socratesModelService.getByID(vo.getId());
//        log.info("----------> request:" + JSONObject.toJSONString(vo));
//        if (socratesModel == null) {
//            return new SuAjaxVoResult(SocratesStateCode.EMPTY.getCode(), SocratesStateCode.EMPTY.getMessage(), null);
//        } else {
//            List<SocratesModelRankUpHandshake> result = socratesModelRankUpHandshakeService.getLastNSuccess(vo.getId(), vo.getTopN());
//            List<Map<String, Object>> versonList = new ArrayList<>();
//            if (!CollectionUtils.isEmpty(result)) {
//                for (SocratesModelRankUpHandshake v : result) {
//                    if (v != null) {
//                        Map<String, Object> version = new HashMap<>();
//                        version.put("modelVersion", v.getModelVersion());
//                        version.put("modelPath", v.getModelPath());
//                        version.put("modelPathLocal", v.getModelPathLocal());
//                        versonList.add(version);
//                    }
//                }
//            }
//
//            Map<String, Object> r = new HashMap<>();
//            r.put("name", socratesModel.getName());
//            r.put("modelAlType", socratesModel.getModelAlType());
//            r.put("modelType", socratesModel.getModelType());
//            r.put("featVersion", socratesModel.getFeatVersion());
//            r.put("modelRepType", socratesModel.getModelRepType());
//            r.put("modelDescription", socratesModel.getModelDescription());
//            r.put("versions", versonList);
//            return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), r);
//        }
//    }
//
//    /**
//     * @param vo
//     * @param request
//     * @return
//     */
//    @PostMapping("/rollback")
//    public SuAjaxVoResult rollback(@RequestBody SocratesModelRollbackVo vo, HttpServletRequest request) {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//
//        SocratesModel socratesModel = SocratesModel.buildRollback(vo.getId(), vo.getModelVersion(),
//                vo.getModelPath(), vo.getModelPathLocal(),
//                user_pin, nick_name, email, null);
//        boolean bl = socratesModelService.rollback(socratesModel);
//        if (bl) {
//            //
//            socratesModel = socratesModelService.getByID(vo.getId());
//            if (socratesModel != null) {
//                socratesModel.setModelMergeState(this.convertMergeState(socratesModel.getModelState(), SocratesModelUpdateType.UNKNOWN.getMessage()));
//                zkRankUpWaveWriteService.rollback(socratesModel);
//                return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), null);
//            } else {
//                return new SuAjaxVoResult(SocratesStateCode.MODELNOTEXIST.getCode(), SocratesStateCode.MODELNOTEXIST.getMessage(), null);
//            }
//        }
//        return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), null);
//    }
//
//
//    /**
//     * Model Delete
//     *
//     * @param vo
//     * @return
//     */
//    @PostMapping("/del")
//    public SuAjaxVoResult del(@RequestBody SocratesModelIdVo vo, HttpServletRequest request) {
//        String user_pin = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getPin() : "";
//        String nick_name = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getNick() : "";
//        String email = LoginContext.getLoginContext() != null ? LoginContext.getLoginContext().getEmail() : "";
//
//        boolean bl = socratesModelService.delBy(vo.getId(), user_pin, nick_name, email);
//        if (bl) {
//            return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), null);
//        }
//        return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), SocratesStateCode.FAIL.getMessage(), null);
//    }
//
//    /**
//     * If or not Model Exist By its name
//     */
//    @GetMapping("/existByName")
//    public SuAjaxVoResult existByName(@RequestParam String name) {
//        boolean bl = socratesModelService.isExistByName(name);
//        return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), bl);
//    }
//
//    /**
//     * change Owner Information
//     */
//    @GetMapping("/changeOwner")
//    public SuAjaxVoResult changeOwner(@RequestParam Integer id,
//                                      @RequestParam String owner,
//                                      @RequestParam String owner_name,
//                                      @RequestParam String owner_email,
//                                      HttpServletRequest request) {
//        boolean bl = socratesModelService.changeOwner(id, owner, owner_name, owner_email);
//        return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), bl);
//    }
//
//    @RequestMapping("/modelTrain")
//    public SuAjaxVoResult modelTrain(@RequestBody SocratesModeTrainVo request) {
//        if (log.isInfoEnabled()) {
//            log.info("训练模型请求参数：" + GsonUtil.toJsonString(request));
//        }
//        Response<PredictResult> PredictResult = socratesModelService.ModelIdTrainning(request);
//        if (PredictResult != null && PredictResult.getStatus().getCode() == 0) {
//            if (PredictResult.getDatas() != null) {
//                //成功
//                return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), PredictResult.getDatas());
//            } else {
//                //成功
//                return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), "打分无结果");
//            }
//
//        }
//
//        if (PredictResult != null && PredictResult.getStatus().getCode() == 1) {
//            if (log.isInfoEnabled()) {
//                log.info(String.format("模型：%s返回异常：%s", request.getModelId(), PredictResult.getMessage()));
//            }
//            //异常
//            return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), "在线模型打分结果异常", PredictResult.getDatas());
//        }
//
//        //结果为空
//        return new SuAjaxVoResult(SocratesStateCode.EMPTY.getCode(), SocratesStateCode.EMPTY.getMessage(), "");
//
//    }
//
//    @RequestMapping("/modelTrainStr")
//    public SuAjaxVoResult modelTrainMap(@RequestBody SocratesModeTrainVo request) {
//        if (log.isInfoEnabled()) {
//            log.info("训练模型请求参数：" + GsonUtil.toJsonString(request));
//        }
//        Response<String> PredictResult = socratesModelService.ModelIdTrainningMap(request);
//        if (PredictResult != null && PredictResult.getStatus().getCode() == 0) {
//            //成功
//            return new SuAjaxVoResult(SocratesStateCode.SUCCESS.getCode(), SocratesStateCode.SUCCESS.getMessage(), PredictResult.getDatas());
//        }
//
//        if (PredictResult != null && PredictResult.getStatus().getCode() == 1) {
//            //异常
//            return new SuAjaxVoResult(SocratesStateCode.FAIL.getCode(), PredictResult.getMessage(), PredictResult.getDatas());
//        }
//
//        //结果为空
//        return new SuAjaxVoResult(SocratesStateCode.EMPTY.getCode(), SocratesStateCode.EMPTY.getMessage(), "");
//
//    }
}
