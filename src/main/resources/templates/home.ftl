***** PropertiesConfiguration *****
<div>
<li>이것은 다이나믹 프로퍼티 : ${ApacheString}!!</li>
<li>다이나믹! ${ApacheInt}</li>
<li>
<#list ApacheList as st>
    ${st}
    <#if st_has_next>
        ,,
    <#else>
        !!!!
    </#if>
</#list>
</li>
</div>
<div>
---------------------------------------------
</div>
*** ReloadableResourceBundleMessageSource ***
<div>
<li>이것은 다이나믹 프로퍼티 : ${SpringString}!!</li>
<li>다이나믹! ${SpringInt}</li>
<li>
<#list SpringList as st>
${st}
    <#if st_has_next>
    ,,
    <#else>
    !!!!
    </#if>
</#list>
</li>
</div>