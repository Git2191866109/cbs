package com.bs.core.entity;

/**
 * User: zhangqh6
 * Date: 2015/12/18 17:12:12
 */
public class ValidInfo {

    private boolean result;
    private String resultMessage;

    private String rule;
    private boolean ruleResult;
    private String data;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public boolean isRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(boolean ruleResult) {
        this.ruleResult = ruleResult;
    }


}
