javascript:function hide(){
/*隐藏tab*/
var ff1 = document.getElementById('app');
ff1.getElementsByTagName('div').item(0).getElementsByTagName('div').item(2).getElementsByTagName('div').item(0).style.display = 'none';
/*隐藏图片*/
var ff2 = document.getElementById('forum-tab-1');
ff2.getElementsByTagName('div').item(0).style.display = 'none';
/*隐藏更新时间*/
ff2.getElementsByTagName('div').item(1).getElementsByTagName('div').item(0).getElementsByTagName('div').item(0).getElementsByTagName('div').item(0).style.display = 'none';
}