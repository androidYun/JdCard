package com.lgy.jdcard.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    public static boolean equalsNullOrEmpty(String res) {
        if (res == null || res.trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 版本信息每条更新换行
     *
     * @param versionInfo
     * @return
     */
    public static String getVersionInfo(String versionInfo) {
        String getVersion = "";
        for (int i = 0; i < versionInfo.length(); i++) {
            String s = versionInfo.charAt(i) + "";
            if (versionInfo.charAt(i) == ';') {
                s = s + "\n";
            }
            getVersion = getVersion.concat(s);
        }
        return getVersion;

    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }


    public static boolean isRmb(String text) {
        Pattern pattern = Pattern
                .compile("^^(([1-9]\\d*)|0)((\\.\\d{1})|(\\.\\d{2}))?$");
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();

    }

    /**
     * 转换付款码的格式
     *
     * @param str
     * @return
     */
    public static String[] getUserCode(String str) {
        return str.split("\\|");
    }

    /**
     * 判断字符串是否为null
     *
     * @param str
     * @return null true
     */
    public static boolean isEmpty(String str) {
        if (null != str && !str.trim().equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 判断list是否为null
     *
     * @param list
     * @return null true
     */
    public static boolean isEmpty(List<?> list) {
        if (null != list && list.size() != 0) {
            return false;
        }
        return true;
    }

    /**
     * 判断list是否为null
     *
     * @param
     * @return null true
     */
    public static boolean isEmpty(Map<?, ?> map) {
        if (null != map && !map.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 返回空值
     */
    public static String isEmptyToString(String str) {
        String s = (isEmpty(str) ? "" : str);
        return s;
    }

    public static String isEmptyToString(String str, String defaultValue) {
        String s = (isEmpty(str) ? defaultValue : str);
        return s;
    }

    public static String isNoEmptyToString(String str, String defaultValue) {
        String s = (isEmpty(str) ? "" : defaultValue);
        return s;
    }

    /**
     * 验证手机号码
     */
    public static boolean isMobileNO(String mobiles) {
        String regExp = "^1[34578][0-9]{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */

    public static boolean isEmail(String email) {
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }
    public static boolean isPwd(String mPwd) {
        if (mPwd == null || mPwd.trim().length() == 0 || mPwd.trim().length() < 6 || mPwd.trim().length() > 16 || isContainChinese(mPwd.trim()))
            return false;
        return true;
    }
    /**
     * 是否包含汉字
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    private final static Pattern emailer = Pattern
            .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    /**
     * 字符串转化成 List
     *
     * @param listText 字符串
     * @param sep      分隔符
     * @return
     */
    public static List<String> StringToList(String listText, String sep) {
        if (listText == null || listText.equals("")) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        String[] text = listText.split(sep);
        for (String str : text) {
            if (!StringUtil.isEmpty(str)) {
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 一行数据 多余的  maxLength的字体 显示...
     *
     * @param content
     * @param maxLength
     * @return
     */
    public static String hideExcessStr(String content, int maxLength) {
        if (isEmpty(content)) {
            return content;
        } else if (content.length() <= maxLength) {
            return content;
        } else {
            return content.substring(0, maxLength) + "...";
        }

    }

}
