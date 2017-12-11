<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div id="header" class="row">
    <div id="header_left" class="col-6 text-center">
        <ul class="row list-unstyled">
            <li class="col-12 col-lg-4 col-xl-3 text-left">zzp后台管理页面</li>
            <li class="d-none d-lg-block d-xl-block col-lg-6 col-xl-5 ">
                <form action="#" method="post" class="form-control-sm">
                <input type="text" name="search" placeholder="请输入您要搜索的内容" class="input-group-sm">
                <button type="submit" name="sbt" class="input-group-sm"><img src="../icon/search.png"></button>
                </form>
            </li>
            <li class="d-none d-xl-block col-xl-4"></li>
        </ul>
    </div>
    <div id="header_right" class="col-6 text-center">
       <!-- <nav class="navbar navbar-expand-sm">
            <button class="navbar-collapse" data-toggle="collapse" data-target="#items">
                <span class="navbar-collapse-icon"></span>
            </button>
        </nav>-->
        <ul class="row list-unstyled">
            <li class="d-none d-md-block d-lg-block d-xl-block col-4">系统公告</li>
            <li class="d-none d-lg-block d-xl-block col-4">锁屏</li>
            <li class="d-lg-none d-xl-none col-4">设置</li>
            <li class="d-lg-none d-xl-none col-4">退出</li>
            <li class="d-none d-lg-inline d-xl-inline col-4">
                <div class="dropdown">
                    <img src="../icon/头像.gif"><span>acsars</span>
                    <button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown">
                        <span class="caret"></span>
                    </button>
                    <div class=" dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#">个人资料</a>
                        <a class="dropdown-item" href="#">修改信息</a>
                        <a class="dropdown-item" href="#">退出</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>