package bean;

import java.util.List;

/**
 * Created by haokuanyi on 2016/9/26.
 */
public class Bean {


    /**
     * change : 0
     * data : [{"money":"14.5","title":"瓒婂崡杩涘彛Tipo鍙嬭皧鐗岀墰濂跺懗闈㈠寘骞�300g"},{"money":"6.5","title":"鍗板害灏艰タ浜氳繘鍙apatonk鍟暘閫氳櫨鐗囧師鍛�40g"},{"money":"400","title":"娆т鸡浜�2016鏄ョ鏃跺皻闀胯寮\u20ac琛崼琛ｈ繍鍔�"},{"money":"300","title":"娆у榫欙紙OMRON锛夌數瀛愯鍘嬭"},{"money":"10","title":"涓浗鍙版咕杩涘彛寮犲悰闆呭皬濡瑰鐢滅敎鍦�"},{"money":"40","title":"闊╁浗杩涘彛娴风墝娴疯嫈2g*40鍖�"},{"money":"30","title":"闊╁浗杩涘彛澶ф槍宀╃煶杩蜂綘娴疯嫈"},{"money":"10","title":"涓浗鍙版咕杩涘彛寮犲悰闆呭皬濡瑰鎷夐潰鏉￠ゼ"},{"money":"10","title":"鑽峰叞杩涘彛鍝堝緱鏂�(DeKroes)鑺濆＋濞佸寲楗煎共"},{"money":"45","title":"鐞浄钀ㄩ┈鏂崱甯冨凹濂堕叒500g"},{"money":"30","title":"鍐呰挋鍙ょ壒浜уザ閰ザ鍒跺搧"},{"money":"50","title":"鐧惧悏绂忔妫掑ザ閰�500g缂ょ悍"},{"money":"50","title":"缇婁钩鐗囧唴钂欏彜鐗逛骇濂堕叒鍎跨濂剁墖350鍏�"},{"money":"20","title":"鐧惧悏绂忔妫掑ザ閰�120g娣峰悎姘存灉鍛冲効绔ュザ閰�"},{"money":"40","title":"鐜嬭\u20ac佸悏妫掓濂堕叒320g娣峰悎姘存灉鍛冲効绔ュザ閰�"},{"money":"40","title":"涓\u20ac鏈极娓稿澧冪殑鎵嬬粯娑傝壊涔�"},{"money":"20","title":"娣峰悎鑽夎帗鍛冲効绔ュザ閰�"}]
     * result : success
     */

    private String change;
    private String result;
    /**
     * money : 14.5
     * title : 瓒婂崡杩涘彛Tipo鍙嬭皧鐗岀墰濂跺懗闈㈠寘骞�300g
     */

    private List<DataBean> data;

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String money;
        private String title;
        private Boolean cb=false;

        public Boolean getCb() {
            return cb;
        }

        public void setCb(Boolean cb) {
            this.cb = cb;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "money='" + money + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Bean{" +
                "change='" + change + '\'' +
                ", result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}
