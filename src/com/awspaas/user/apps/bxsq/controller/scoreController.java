package com.awspaas.user.apps.bxsq.controller;

import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.commons.htmlframework.HtmlPageTemplate;
import com.actionsoft.bpms.server.UserContext;
import com.actionsoft.bpms.server.bind.annotation.Controller;
import com.actionsoft.bpms.server.bind.annotation.Mapping;
import com.actionsoft.sdk.local.SDK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class scoreController {
	
	@Mapping("com.awspaas.user.apps.bxsq_hry")
	public String getServerPage(UserContext me){
		String ckdtablename="BO_EU_FLOW";//报销单

		Map<String,Object> maps=new HashMap<String,Object>();
		List<BO> bllist= SDK.getBOAPI().query(ckdtablename).list();
		System.out.println(bllist.size());
		maps.put("reimburseList", bllist);
		return HtmlPageTemplate.merge("com.awspaas.user.apps.bxsq", "bxsq_list.html",maps);
		
	}

	@Mapping("com.awspaas.user.apps.bxsq_viewbxd")
	public String viewbxd(UserContext me,String bindid,String id){
		String ckdtablename="BO_EU_FLOW";//报销单
		Map<String,Object> maps=new HashMap<String,Object>();
		BO bo = SDK.getBOAPI().get(ckdtablename, id);
		maps.put("bxdBo", bo);
		return HtmlPageTemplate.merge("com.awspaas.user.apps.bxsq", "bxsq_view.html",maps);

	}
}
