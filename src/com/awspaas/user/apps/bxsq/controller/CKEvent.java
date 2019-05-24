package com.awspaas.user.apps.bxsq.controller;

import com.actionsoft.bpms.bo.engine.BO;
import com.actionsoft.bpms.bpmn.engine.core.delegate.ProcessExecutionContext;
import com.actionsoft.bpms.bpmn.engine.listener.ExecuteListenerInterface;
import com.actionsoft.sdk.local.SDK;
import com.awspaas.user.apps.bxsq.reimburse.KCdao;

import java.util.List;


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
	    //Ҫ��ȡ���ⵥ�ϵĳ�����Ʒ��Ϣ
		
		//��1������ó��ⵥ�����bindid�ֶε�ֵ�����ӱ���ͨ��bindid�ֶ���������
		String fbindid=arg0.getProcessInstance().getId();  //��õ�ǰ����ʵ����bindid
        /*���´�����Ի�ó��ⵥ���������������Ϣ
		String ckdtablename="bo_yh_ckdxx";//���ⵥ��������
        BO fckd=SDK.getBOAPI().query(ckdtablename).detailByBindId(fbindid);
        String cno=(String)fckd.get("CNO");  //���ⵥ���
		String cdate=(String)fckd.get("CDATE"); //��������
		*/
		
		//��2�������ݳ��ⵥ����bindidȥ��ѯ���ⵥ�ӱ����Ʒ��Ϣ
		String ckdmxtablename = "bo_yh_ckspmx";//���ⵥ�ӱ�����	
		List<BO> ckdmx= SDK.getBOAPI().query(ckdmxtablename).list();
		System.out.println("��ѯ���ļ�¼����"+ckdmx.size());
		//��3�������ݲ�ѯ���ĳ�����Ʒ��������¸���Ʒ�����Ϣ
		KCdao fkcdao=new KCdao();
		String fgno;
		String fnum;
		for(int i=0;i<ckdmx.size();i++){
			fgno=(String)ckdmx.get(i).get("GNO");
			fnum=(String)ckdmx.get(i).get("NUMBER");
			System.out.println("GNO:"+fgno);
			System.out.println("NUMBER:"+fnum);
			fkcdao.updateKC(fgno, fnum);
		}
	}
}
