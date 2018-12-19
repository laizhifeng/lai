<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
				所属地区：<select style="height: 30px; width: 80px;" id="h_region">
					<option value="思明区">思明区</option>
					<option value="湖里区">湖里区</option>
					<option value="集美区">集美区</option>
					<option value="海沧区">海沧区</option>
					<option value="同安区">同安区</option>
					<option value="翔安区">翔安区</option>
				</select> 
				<br> 
				小区名：<input class="h_add" type="text" id="h_estate" placeholder="例：莲花新城"> 
				<div class="ErrorInfo" id="h_estate_error">&nbsp;</div>
				
				单元号：<input class="h_add" type="text" id="h_unitNumber" placeholder="例：8单元"> 
				<div class="ErrorInfo" id="h_unitNumber_error">&nbsp;</div>
				 
				房间号：<input class="h_add" type="text" id="h_roomNo" placeholder="例：1604号"> 
				<div class="ErrorInfo" id="h_roomNo_error">&nbsp;</div>
				 
				面积&ensp;&ensp;：<input class="h_add" type="text" id="h_area" placeholder="例：200平方米"> 
				<div class="ErrorInfo" id="h_area_error">&nbsp;</div> 
				
				朝向&ensp;&ensp;：<input class="h_add" type="text" id="h_orientation" placeholder="例：朝南" > 				
				<div class="ErrorInfo" id="h_orientation_error">&nbsp;</div>
				
				装修&ensp;&ensp;：<input type="radio" id="h_fitment" style="height: 15px; width: 15px;" name="h_fitment" value="简装" checked="checked">简装 
					<input type="radio" id="h_fitment" style="height: 15px; width: 15px;" name="h_fitment" value="精装">精装 
				<br>
				是否双气：<input type="radio" id="h_isDoubleAir" style="height: 15px; width: 15px;" name="h_isDoubleAir" value="1">是 
					<input type="radio" id="h_isDoubleAir" style="height: 15px; width: 15px;" name="h_isDoubleAir" value="0" checked="checked">否
				<br> 
				限住人数：<input class="h_add" type="text" id="h_limit" placeholder="例：8,只能输入整数" oninput="value=value.replace(/\D/g,'')">人
				<div class="ErrorInfo" id="h_limit_error">&nbsp;</div> 
				
				配备设施：<br><textarea class="h_add" rows="" cols="" id="h_facility" style="height: 80px; width: 250px;" placeholder="例：洗衣机"></textarea>
				<br>
				
				租金：<input class="h_add" type="text" id="h_price" placeholder="例：2500,只能输入数字" oninput="value=value.replace(/[^\d.]/g,'')">元 <br>
				<div class="ErrorInfo" id="h_price_error">&nbsp;</div>
				
				房屋状态：<select style="height: 30px; width: 80px;" id="h_status">
							<option value="0">未出租</option>
							<option value="1">已出租</option>
							<option value="2">停止租出</option>
					</select> <br> 
				房屋完整地址：<br><textarea class="h_add" rows="" cols="" id="h_address" style="height: 80px; width: 250px;"placeholder="例：集美区莲花新城湖元8单元1604号"></textarea>
				<div class="ErrorInfo" id="add_h_address_error">&nbsp;</div>
				
				房屋图片：<div class="houseImg" id="houseImg">
						<img src="" id="h_img">
					</div>
				<input id="pic" type="file" name='addpic' onchange="selectFile()" />