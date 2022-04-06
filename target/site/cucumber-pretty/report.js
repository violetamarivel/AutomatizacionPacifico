$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("services.feature");
formatter.feature({
  "line": 1,
  "name": "API/Services - response validation",
  "description": "",
  "id": "api/services---response-validation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3433859500,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Validate auth token service",
  "description": "",
  "id": "api/services---response-validation;validate-auth-token-service",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Testservicio"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I validate POST auth service",
  "rows": [
    {
      "cells": [
        "resource",
        "expStatus",
        "expAccessToken",
        "expTokentype",
        "comments"
      ],
      "line": 6
    },
    {
      "cells": [
        "fc3220d2-0bcf-4bd4-8ffa-03f7837d61aa",
        "200",
        "true",
        "true",
        "Solo Integracion"
      ],
      "line": 7
    },
    {
      "cells": [
        "123456",
        "400",
        "",
        "",
        "Solo Integracion"
      ],
      "line": 8
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesSteps.iValidatePOSTAuthService(DataTable)"
});
formatter.result({
  "duration": 4518524000,
  "error_message": "java.lang.IllegalStateException: Cannot parse object because no supported Content-Type was not specified in response. Content-Type was \u0027text/html; charset\u003dutf-8\u0027.\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:83)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrapNoCoerce.callConstructor(ConstructorSite.java:105)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:60)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:235)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:247)\r\n\tat io.restassured.internal.mapping.ObjectMapping.deserialize(ObjectMapping.groovy:82)\r\n\tat io.restassured.internal.mapping.ObjectMapping$deserialize.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)\r\n\tat io.restassured.internal.RestAssuredResponseOptionsGroovyImpl.as(RestAssuredResponseOptionsGroovyImpl.groovy:222)\r\n\tat io.restassured.internal.RestAssuredResponseOptionsImpl.as(RestAssuredResponseOptionsImpl.java:164)\r\n\tat com.pacifico.test.steps.ServicesSteps.iValidatePOSTAuthService(ServicesSteps.java:43)\r\n\tat ✽.Then I validate POST auth service(services.feature:5)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 157711600,
  "status": "passed"
});
});