package com.awspaas.user.apps.bxsq.reimburse;

import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListenerInterface;
import com.actionsoft.sdk.local.SDK;
import com.actionsoft.sdk.local.api.BOAPI;

public class CKEvent implements ExecuteListenerInterface {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(ProcessExecutionContext arg0) throws Exception {
	    //要获取出库单上的出库商品信息
		
		//第1步：获得出库单主表的bindid字段的值（主从表是通过bindid字段来关联）
		String ckdtablename="BO_EU_FLOW";//报销单
        //BO fckd=SDK.getBOAPI().query(ckdtablename).detailByBindId(fbindid);
		 /*以下代码可以获得出库单主表单的相关输入信息
		String ckdtablename="bo_yh_ckdxx";//出库单主表名称
        BO fckd=SDK.getBOAPI().query(ckdtablename).detailByBindId(fbindid);
        String cno=(String)fckd.get("CNO");  //出库单编号
		String cdate=(String)fckd.get("CDATE"); //出库日期
		*/
		
        BOAPI boAPI= SDK.getBOAPI();
        boAPI.updateByBindId(ckdtablename, arg0.getProcessInstance().getId(),"STATUS", 1);
		
		//第2步：根据出库单主表bindid去查询出库单子表的商品信息
		/*String ckdmxtablename = "bo_yh_ckspmx";//出库单从表名称	
		List<BO> ckdmx=SDK.getBOAPI().query(ckdmxtablename).addQuery("BINDID = ",fbindid).list();
		System.out.println("查询到的记录数："+ckdmx.size());
		//第3步：根据查询到的出库商品编号来更新该商品库存信息
		KCdao fkcdao=new KCdao();
		String fgno;
		String fnum;
		for(int i=0;i<ckdmx.size();i++){
			fgno=(String)ckdmx.get(i).get("GNO");
			fnum=(String)ckdmx.get(i).get("NUMBER");
			System.out.println("GNO:"+fgno);
			System.out.println("NUMBER:"+fnum);
			fkcdao.updateKC(fgno, fnum);
		}*/
	}
}
