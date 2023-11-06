package ${package.Controller};

import ${package.Service}.${table.serviceName};
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @since ${.now?string('yyyy-MM-dd hh:mm:ss')}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.name}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${table.serviceImplName?uncap_first};



}
</#if>
