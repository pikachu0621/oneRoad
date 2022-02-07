javascript:function hide(){
/*隐藏tab*/
var ff1 = document.getElementById('app');
ff1.getElementsByTagName('div').item(0).getElementsByTagName('div').item(2).getElementsByTagName('div').item(0).style.display = 'none';
/*隐藏图片*/
var ff2 = document.getElementById('forum-tab-1');
ff2.getElementsByTagName('div').item(0).style.display = 'none';
/*隐藏更新时间*/
ff2.getElementsByTagName('div').item(1).getElementsByTagName('div').item(0).getElementsByTagName('div').item(0).getElementsByTagName('div').item(0).style.display = 'none';
/*去除超链接点击*/
var elementsByTagName = document.getElementsByTagName('div');
for (let i = 0; i < elementsByTagName.length; i++) {
    if(elementsByTagName[i].className == 'area-chart-header-item name-province hyperlink'){
    	elementsByTagName[i].className = 'area-chart-header-item name-province';
	}
}
}