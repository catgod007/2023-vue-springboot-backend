package org.source.until;

import lombok.Data;

@Data
public class AjaxResult {
    //返回是否成功的判断
    private boolean success=true;
    private String msg="操作成功";

    public AjaxResult() {
    }

    public AjaxResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
