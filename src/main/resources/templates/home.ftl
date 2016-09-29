이것은 다이나믹 프로퍼티 : ${string}!!
다이나믹! ${int}
<#list list as st>
    ${st}
    <#if st_has_next>
        ,,
    <#else>
        !!!!
    </#if>
</#list>