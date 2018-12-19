<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<div class="search">                
                <input  type="text" class="search_box" >
                <input type="button" class="search_button" style="cursor:pointer;" value="搜索">
                <input type="button" class="del_batch_button" value="批量删除">
                <p class="notfound" >没有查询到相关信息</p>
            </div>
            <div class="show_list" >
                <div class="del_div" >
					<button id="del_all" >全选</button>
					<button id="del_none" >全不选</button>
					<button id="del_affirm" >确认</button>
					<button id="del_cancel" >取消</button>
				</div>
				
                <ul id="showUl">
                </ul>
             </div>
             <div class="pagediv" >
             	<a id="btn0"></a>&nbsp;
                <a id="datalen"></a>&nbsp;
                <a  href="#" id="btn1">首页</a>
                <a  href="#" id="btn2">上一页</a>
                <a  href="#" id="btn3">下一页</a>
                <a  href="#" id="btn4">尾页</a>&nbsp;
                <a>转到&nbsp;</a>
                <input id="changePage" type="text" size="1" maxlength="4"/>
                <a>页&nbsp;</a>
                <a  href="#" id="btn5">跳转</a>
              </div>