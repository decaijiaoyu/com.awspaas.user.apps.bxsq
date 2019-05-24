package com.awspaas.user.apps.bxsq.reimburse;

import com.actionsoft.bpms.util.DBSql;

import java.sql.Connection;

public class KCdao {
	  public boolean updateKC(String FGno,String FNum){	
			boolean fresult=false;
			Connection conn = null;
			String kctable="BO_YH_SPKCXX"; //商品库存信息表
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
				// 关闭资源
				DBSql.close(conn);
			}
			return fresult;
		  }
}
