package com.atguigu.common.constant;

/**
 * Created with IntelliJ IDEA
 * User: GHYANG
 * Date: 2020-06-02
 * Description:
 */
public class ProductConstant {
    public enum AttrEnu{
        ATTR_TYPE_BASE(1,"基本属性"),ATTR_TYPE_SALE(0,"销售属性");
        private int code;
        private String msg;
        AttrEnu(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }


        public String getMsg() {
            return msg;
        }

    }
}
