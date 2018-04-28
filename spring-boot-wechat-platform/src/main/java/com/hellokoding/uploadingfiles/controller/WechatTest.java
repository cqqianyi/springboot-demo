package com.hellokoding.uploadingfiles.controller;

import com.alibaba.fastjson.JSON;
import weixin.popular.api.TokenAPI;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.token.Token;
import weixin.popular.bean.user.FollowResult;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-04-18
 *
 TokenAPI access_token 获取
 MediaAPI 多媒体上传下载(临时素材)
 MaterialAPI 永久素材
 MenuAPI 菜单、个性化菜单
 MessageAPI 信息发送（客服消息、群发消息、模板消息）
 PayMchAPI 支付订单、红包、企业付款、代扣费(商户平台版)
 QrcodeAPI 二维码
 SnsAPI 网签授权
 UserAPI 用户管理、分组、标签、黑名单
 ShorturlAPI 长链接转短链接
 TicketAPI JSAPI ticket
 ComponentAPI 第三方平台开发
 CallbackipAPI 获取微信服务器IP地址
 ClearQuotaAPI 接口调用频次清零
 PoiAPI 微信门店 @Moyq5 (贡献)
 CardAPI 微信卡券 @Moyq5 (贡献)
 ShakearoundAPI 微信摇一摇周边 @Moyq5 (贡献)
 DatacubeAPI 数据统计 @Moyq5 (贡献)
 CustomserviceAPI 客服功能 @ConciseA (贡献)
 WxaAPI 微信小程序
 WxopenAPI 微信小程序
 CommentAPI 文章评论留言
 OpenAPI 微信开放平台帐号管理
 **/
public class WechatTest {
    public static void main(String[] args) {

     String accessToken="8_ybs_R986P70EyVyIY4-3tqyo0X30Mz2uFEnnbY2ASLOsalpxzEi8su4GmLuFHesxVfrfYW9RR0vRjmedp_OPrrDWzXz9f4Aanw2v73dZhDb8CZ0L4WvCufAgqM44PkLXUfx86yOdvVHYbqa1ZLKaABAMYX";
        //
//     Token token=   TokenAPI.token("wxb13b8c580a29ec6e","61a14ae12c2f1522a5c294d3b1457131");
     Token token=TokenAPI.token("wx994d9491ac99b1b7","2d7b955b181cd626230ea4648eb90b44");
        System.out.println(JSON.toJSONString(token));
        accessToken=token.getAccess_token();
        //{"access_token":"","expires_in":7200,"success":true}


     FollowResult followResult=  UserAPI.userGet(accessToken,"");


        /**
         *
         *
         * 清理功能开发：
         * 1，清除openID 表
         * 2.标签删除。
         *
         * 微信打标签需求：
         * 首先分类进行打标签
         * 1.过滤出所打的标签类
         * 2.开启多个线程进行提交.分批进行打标签。
         * 3.剩余openID进行比对，打其他标签需求。
         * 4.两个表过滤出未包含的openid.
         * 5.进行分批打标签
         * 6.错误信息插入，再次循环打标签。记录错误信息
         * 7.
         *
         */

    }
}


