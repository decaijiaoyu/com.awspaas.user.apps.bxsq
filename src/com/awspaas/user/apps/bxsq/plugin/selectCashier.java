package com.awspaas.user.apps.bxsq.plugin;

import com.actionsoft.bpms.commons.at.AbstExpression;
import com.actionsoft.bpms.commons.at.ExpressionContext;
import com.actionsoft.exception.AWSExpressionException;

//出纳人选择@公式
public class selectCashier extends AbstExpression {
    public selectCashier(ExpressionContext atContext, String expressionValue) {
        super(atContext, expressionValue);
    }

    @Override
    public String execute(String expression) throws AWSExpressionException {
        //获取第一个参数
        String cashierType=getParameter(expression,1);
        //根据报销类型选择出纳人
        if("差旅费".equals(cashierType)){
            return "uilsr";
        }else{
            return "qzlsr";
        }
    }


}
