package com.awspaas.user.apps.bxsq.reimburse;

import com.actionsoft.bpms.util.DBSql;

import java.sql.Connection;

public class KCdao {
	  public boolean updateKC(String FGno,String FNum){	
			boolean fresult=false;
			Connection conn = null;
			String kctable="BO_YH_SPKCXX"; //��Ʒ�����Ϣ��
			try {
				conn = DBSql.open();
				conn.setAutoCommit(false);
				StringBuffer fsql = new StringBuffer();
		        fsql.append("UPDATE BO_YH_SPKCXX set STORENUMBER=STORENUMBER-").append(FNum).append(" WHERE  GNO='").append(FGno).append("'");
			    System.out.println(fsql.toString());
			    DBSql.update(fsql.toString());
			}catch (Exception e) {
			   fresult=false;
			} finally {
				// �ر���Դ
				DBSql.close(conn);
			}
			return fresult;
		  }
}
