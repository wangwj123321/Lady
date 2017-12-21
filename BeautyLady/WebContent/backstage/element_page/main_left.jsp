<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <div id="main_left">
            <div class="admin">
                <img src="../icon/person.gif">欢迎系统管理员：<strong>acsars</strong>
            </div>
            <div id="oper_list">
                <div>
                    <a data-toggle="collapse" data-parent="#oper_list" data-target="#order_oper" href="javascript:void(0)">订单管理</a>
                    <div class="collapse" id="order_oper">
                        <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="javaScript:void(0)" onclick="getStorageOrder('StorageOrder','findOrder')">商品入库单</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)" onclick="getOrderList(1)">订单列表</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">合并订单</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">订单打印</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">添加订单</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">发货单列表</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">换货单列表</a></li>
                        </ul>
                    </div>
                </div>
                <div>
                    <a data-toggle="collapse" data-parent="#oper_list" data-target="#member_oper" href="javascript:void(0)">会员管理</a>
                    <div class="collapse" id="member_oper">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="#">会员列表</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">未激活会员</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">团队系谱图</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">会员推荐图</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">推荐列表</a></li>
                        </ul>
                    </div>
                </div>
                <div>
                    <a data-toggle="collapse" data-parent="#oper_list" data-target="#msg_oper" href="javascript:void(0)">信息通知</a>
                    <div class="collapse" id="msg_oper">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="#">站内消息/留言</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">短信</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">邮件</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">微信</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">客服</a></li>
                        </ul>
                    </div>
                </div>
                <div>
                    <a data-toggle="collapse" data-parent="#oper_list" data-target="#sys_oper" href="javascript:void(0)">商品管理</a>
                    <div class="collapse" id="sys_oper">
                        <ul class="navbar-nav">
                        	<li class="nav-item">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">商品列表</a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'Category')">大类</a>
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'SubClasses')">小类</a>
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'Color')">颜色</a>
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'Size')">尺码</a>
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'Band')">波段</a>
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'Theme')">主题</a>
                                    <a class="dropdown-item" href="javascirpt:void(0)" onclick="return initProduct(1,'Series')">系列</a>
                                </div>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="javaScript:void(0)" onclick="addProduct()">添加新商品</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">商品分类</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">用户评论</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">商品回收站</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">库存管理</a></li>
                        </ul>
                    </div>
                </div>
                <!-- <div>
                    <a data-toggle="collapse" data-parent="#oper_list" data-target="#product_oper" href="javascript:void(0)">商品管理</a>
                    <div class="collapse" id="product_oper">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="#">数据备份</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">邮件/短信管理</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">上传/下载</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">权限</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">网站设置</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">第三方支付</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">提现 /转账 出入账汇率</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">平台设置</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">声音文件</a></li>
                        </ul>
                    </div>
                </div> -->
                <div>
                    <a data-toggle="collapse" data-parent="#oper_list" data-target="#product_oper" href="javascript:void(0)">用户管理</a>
                    <div class="collapse" id="product_oper">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">用户列表</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">新增用户</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">上传/下载</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">权限</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">网站设置</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">第三方支付</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">提现 /转账 出入账汇率</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">平台设置</a></li>
                            <li class="nav-item"><a class="nav-link" href="javascirpt:void(0)">声音文件</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>