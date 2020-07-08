/**
 * easyui主题来源：https://www.insdep.com/temp/examples/theme/default/index.html#
 * 导航来源:https://adminlte.io/
 * 
 * 
 */
//导航数据可后台获取
var dataJson = [{
	"icon": "icon-sys",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getGroupManageUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getSystemSetUrl",
		"icon": "my-ms07"
	}, {
		"menuname": "系统管理",
		"url": "url/getUserManageUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getLogManageUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "平台-系统管理",
		"url": "url/modelManage",
		"icon": "icon-nav"
	}, {
		"menuname": "平台-系统管理",
		"url": "url/pageManage",
		"icon": "icon-nav"
	}, {
		"menuname": "Icon-系统管理",
		"url": "url/getIconsManageUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "平台-系统管理(前后台)",
		"url": "url/pageDesign",
		"icon": "icon-nav"
	}]
}, {
	"icon": "icon-sys",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "page/systemmanage/versionLook.jsp",
		"icon": "icon-nav"
	}]
}, {
	"icon": "my-treegrid",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getCompanyUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getAddrbookUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getEmployeeUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getOrganizationunitUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getRegionUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getTitleUrl",
		"icon": "icon-nav"
	}]
}, {
	"icon": "my-treegrid",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getMeasureunitUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getReasoncodeUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getMainctlUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getProdcategUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getProd_categ_appliUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getModelApplyUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getDictUrl",
		"icon": "my-table-column"
	}, {
		"menuname": "系统管理",
		"url": "url/getRecentPurBasedataUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getRecentPurParamUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getProd_categ_changeUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getProd_categ_queryUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getSetUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getPeitaoPurUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getProductUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getProductRecyleUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getPurCompsetUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getPriceRangeUrl",
		"icon": "my-treegrid"
	}, {
		"menuname": "系统管理",
		"url": "url/getSupplierPriceUrl",
		"icon": "my-treegrid"
	}]
}, {
	"icon": "my-treegrid",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getPro_reqUrl",
		"icon": "my-treegrid"
	}]
}, {
	"icon": "my-treegrid",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getQuoteUrl",
		"icon": "icon-nav"
	}]
}, {
	"icon": "icon-sys",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getNeedManageListUrl",
		"icon": "icon-nav"
	}]
}, {
	"icon": "icon-sys",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getSup_regUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getTempSupUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getBidSupUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getTempCheckUrl",
		"icon": "icon-sys"
	}, {
		"menuname": "系统管理",
		"url": "url/getBidCheckUrl",
		"icon": "icon-sys"
	}]
}, {
	"icon": "icon-sys",
	"menuname": "系统管理",
	"menus": [{
		"menuname": "系统管理",
		"url": "url/getPriceConfirmListUrl",
		"icon": "icon-nav"
	}, {
		"menuname": "系统管理",
		"url": "url/getPriceConfirmFormUrl",
		"icon": "icon-nav"
	}]
}];
//填充DOM初始化菜单
var loadMenuHtml = function(menuData){
	
	$('.sidebar').empty();
	//定义菜单容器sidebar-menu
	var menuBox = $("<ul></ul>").addClass("sidebar-menu");
	var menuList = "";
	menuList +='<li class="header">导航菜单</li>'
	
	var init = function(){
		for(var i = 0;i<menuData.length;i++){
			var firstLayerList = menuData[i];
			if(firstLayerList.menus.length && firstLayerList.menus.length>0 ){
				menuList += '<li class="treeview">';
				menuList += '<a href="javascript:;">';
				/**' + firstLayerList.icon +'**/
				menuList +=	'<i class="fa fa-folder"></i>';
				menuList +=	'<span>' + firstLayerList.menuname +'</span>';
				menuList +=	'<span class="pull-right-container">';
				menuList +=		'<i class="fa fa-angle-left pull-right"></i>';
				menuList +=	'</span>';
				menuList += '</a>';
				menuList += addFirstLayer(firstLayerList.menus);
				menuList += '</li>';
				
			}else{
				menuList += '<li>';
				menuList += '<a href="javascript:;">';
				// ' + firstLayerList.icon +'
				menuList +=	'<i class="fa fa-folder"></i>';
				menuList +=	'<span>' + firstLayerList.menuname +'</span>';
				menuList +=	'<span class="pull-right-container">';
				menuList +=		'<i class="fa fa-angle-left pull-right"></i>';
				menuList +=	'</span>';
				menuList += '</a>';
				menuList += '</li>';
			}
		}
		menuBox.append(menuList);
		$('.sidebar').append(menuBox);
		$.sidebarMenu($('.sidebar-menu'));
	}
	var addFirstLayer = function(firstLayerData){
		var firstLayerHtml ='<ul class="treeview-menu">';
		for(var i=0;i<firstLayerData.length;i++){
			if(firstLayerData[i]["menus"]){
				firstLayerHtml+= '<li>'
				firstLayerHtml+= '	<a href="javascript:;" gherf="'+ firstLayerData[i].url +'">';
				// firstLayerData[i].icon
				firstLayerHtml+= '	<i class="fa fa-circle-o"></i>' + firstLayerData[i].menuname;
				firstLayerHtml+= '  <span class="pull-right-container">'
				firstLayerHtml+= '<i class="fa fa-angle-left pull-right"></i>'     
				firstLayerHtml+= '</span>'           
				firstLayerHtml+= '</a>'
				firstLayerHtml +=	addFirstLayer(firstLayerData[i]["menus"]);
                firstLayerHtml+= '</li>';                                    				
			}else{
				firstLayerHtml+= '<li>'
				firstLayerHtml+= '	<a href="javascript:;" gherf="'+ firstLayerData[i].url +'">';
				// ' + firstLayerData[i].icon + '
				firstLayerHtml+= '	<i class="fa fa-circle-o"></i>' + firstLayerData[i].menuname +'</a>';
				firstLayerHtml+= '</li>';
			}
		}
		firstLayerHtml+='</ul>';
		return firstLayerHtml;
	}
	if(menuData){
		init();
	}else{

	}
	// var addOtherLayer = function(){
	// 	var otherLayerHtml = "";

	// 	return otherLayerHtml;
	// }


};
$(function () {
	loadMenuHtml(dataJson);
	//绑定事件
	$('.theme-header-navigate-combobox').each(function () {
		$(this).combo('panel').panel({
			cls: "theme-header-navigate-combobox-panel"
		});
	});

	var theme_left_layout = $(".theme-layout").layout("panel", 'west');
	var theme_left_menu_switch = true;
	$(".theme-left-menu-switch,.sidebar-toggle").on("click", function (event) {
		if (theme_left_menu_switch) {
			$(".theme-left-layout").addClass('theme-nav-mini');
			//$(".theme-left-user-panel").hide(); /*隐藏左侧菜单用户面板*/
			// $(".theme-left-menu dl dd").hide(); /*隐藏左侧子菜单*/

			theme_left_layout.panel('resize', {
				width: 50
			});
			$(".theme-left-menu").css({
				"width": "50px"
			});

			theme_left_menu_switch = false;
		} else {
			$(".theme-left-layout").removeClass('theme-nav-mini');
			// $(".theme-left-user-panel").show(); /*显示左侧菜单用户面板*/
			// $(".theme-left-menu dl dd").show(); /*显示左侧子菜单*/

			theme_left_layout.panel('resize', {
				width: 200
			});
			$(".theme-left-menu").css({
				"width": "200px"
			});

			theme_left_menu_switch = true;
		}
		$(".theme-layout").layout('resize', {
			width: '100%'
		}); /*重置框架*/
	});

	var theme_left_menu_switch_hide = true;
	$(".theme-left-menu-switch-hide").on("click", function (event) {
		if (theme_left_menu_switch_hide) {
			//theme_left_layout.panel('resize',{width:1});
			$(".theme-layout").layout('remove', 'west');
			//$(".theme-left-layout").addClass('theme-left-layout-hide');
			theme_left_menu_switch_hide = false;
		} else {
			//theme_left_layout.panel('resize',{width:180});
			$(".theme-layout").layout('add', {
				region: 'west',
				bodyCls: 'theme-left-layout',
				href: 'menu_hide_left_content.html',
				border: false,
				width: 200
			});
			//$(".theme-left-layout").removeClass('theme-left-layout-hide');
			theme_left_menu_switch_hide = true;
		}
		$(".theme-layout").layout('resize', {
			width: '100%'
		}); /*重置框架*/
	});


	$(".theme-left-menu dl dt,.theme-inside-left-menu dl dt").on("click", function (event) {
		if (theme_left_menu_switch) {
			var node = $(this).next("dd");
			if (node.is(":hidden")) {
				node.show(); /*如果元素为隐藏,则将它显现*/
			} else {
				node.hide(); /*如果元素为显现,则将其隐藏*/
			}
		}
	});

	/*
	$(".theme-left-menu dl dt").on("mousemove",function(event) {
		if(!theme_left_menu_switch){
			var node=$(this).next("dd");
			node.addClass(".theme-left-menu-node-show");
			
		}
	});
	*/

	$(".theme-left-menu li").on("click", function (event) {
		$(".theme-left-menu li").removeClass("selected");
		$(this).addClass("selected");
	});
	$(".theme-inside-left-menu li").on("click", function (event) {
		$(".theme-inside-left-menu li").removeClass("selected");
		$(this).addClass("selected");
	});


	/*
	setInterval(function(){
		var nowDate  = new Date();
		var nowYear  = nowDate.getFullYear();
		var nowMonth = nowDate.getMonth().toString().length==1?"0"+nowDate.getMonth():nowDate.getMonth();
		var nowDays  = nowDate.getDate().toString().length==1?"0"+nowDate.getDate():nowDate.getDate();

		var nowHours = nowDate.getHours().toString().length==1?"0"+nowDate.getHours():nowDate.getHours();
		var nowMinute  = nowDate.getMinutes().toString().length==1?"0"+nowDate.getMinutes():nowDate.getMinutes();
		var nowSeconds  = nowDate.getSeconds().toString().length==1?"0"+nowDate.getSeconds():nowDate.getSeconds();

	    $("#theme-header-navigate-datetime").html(nowYear+"年"+nowMonth+"月"+nowDays+"日 "+nowHours+":"+nowMinute+":"+nowSeconds);
	},1000);
	*/


});