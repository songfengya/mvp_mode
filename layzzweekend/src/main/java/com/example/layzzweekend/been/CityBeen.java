package com.example.layzzweekend.been;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CityBeen implements Serializable{

    /**
     * status : 200
     * append_info : {}
     * page_total : 0
     * pagenumber : 0
     * result : [{"city_list":[{"city_id":53,"city_name":"北京","province_id":3,"province_name":"北京"},{"city_id":321,"city_name":"上海","province_id":25,"province_name":"上海"},{"city_id":80,"city_name":"广州","province_id":6,"province_name":"广东"},{"city_id":91,"city_name":"深圳","province_id":6,"province_name":"广东"},{"city_id":383,"city_name":"杭州","province_id":31,"province_name":"浙江"},{"city_id":324,"city_name":"成都","province_id":26,"province_name":"四川"},{"city_id":394,"city_name":"重庆","province_id":32,"province_name":"重庆"},{"city_id":192,"city_name":"武汉","province_id":13,"province_name":"湖北"},{"city_id":317,"city_name":"西安","province_id":24,"province_name":"陕西"},{"city_id":199,"city_name":"长沙","province_id":14,"province_name":"湖南"},{"city_id":226,"city_name":"苏州","province_id":16,"province_name":"江苏"},{"city_id":224,"city_name":"南京","province_id":16,"province_name":"江苏"},{"city_id":248,"city_name":"大连","province_id":18,"province_name":"辽宁"},{"city_id":256,"city_name":"沈阳","province_id":18,"province_name":"辽宁"},{"city_id":292,"city_name":"青岛","province_id":22,"province_name":"山东"}],"begin_key":"hot"},{"city_list":[{"city_id":150,"city_name":"安阳","province_id":11,"province_name":"河南"},{"city_id":112,"city_name":"安顺","province_id":8,"province_name":"贵州"},{"city_id":36,"city_name":"安庆","province_id":2,"province_name":"安徽"},{"city_id":245,"city_name":"鞍山","province_id":18,"province_name":"辽宁"},{"city_id":259,"city_name":"阿拉善盟","province_id":19,"province_name":"内蒙古"},{"city_id":311,"city_name":"安康","province_id":24,"province_name":"陕西"},{"city_id":322,"city_name":"阿坝","province_id":26,"province_name":"四川"},{"city_id":344,"city_name":"阿里","province_id":28,"province_name":"西藏"},{"city_id":351,"city_name":"阿克苏","province_id":29,"province_name":"新疆"},{"city_id":352,"city_name":"阿拉尔","province_id":29,"province_name":"新疆"},{"city_id":3114,"city_name":"阿勒泰","province_id":29,"province_name":"新疆"}],"begin_key":"A"},{"city_list":[{"city_id":53,"city_name":"北京","province_id":3,"province_name":"北京"},{"city_id":37,"city_name":"蚌埠","province_id":2,"province_name":"安徽"},{"city_id":63,"city_name":"白银","province_id":5,"province_name":"甘肃"},{"city_id":98,"city_name":"百色","province_id":7,"province_name":"广西"},{"city_id":99,"city_name":"北海","province_id":7,"province_name":"广西"},{"city_id":113,"city_name":"毕节","province_id":8,"province_name":"贵州"},{"city_id":121,"city_name":"白沙","province_id":9,"province_name":"海南"},{"city_id":122,"city_name":"保亭","province_id":9,"province_name":"海南"},{"city_id":139,"city_name":"保定","province_id":10,"province_name":"河北"},{"city_id":212,"city_name":"白城","province_id":15,"province_name":"吉林"},{"city_id":213,"city_name":"白山","province_id":15,"province_name":"吉林"},{"city_id":246,"city_name":"本溪","province_id":18,"province_name":"辽宁"},{"city_id":260,"city_name":"巴彦淖尔市","province_id":19,"province_name":"内蒙古"},{"city_id":261,"city_name":"包头","province_id":19,"province_name":"内蒙古"},{"city_id":283,"city_name":"滨州","province_id":22,"province_name":"山东"},{"city_id":312,"city_name":"宝鸡","province_id":24,"province_name":"陕西"},{"city_id":323,"city_name":"巴中","province_id":26,"province_name":"四川"},{"city_id":353,"city_name":"巴音郭楞","province_id":29,"province_name":"新疆"},{"city_id":354,"city_name":"博尔塔拉","province_id":29,"province_name":"新疆"},{"city_id":367,"city_name":"保山","province_id":30,"province_name":"云南"}],"begin_key":"B"},{"city_list":[{"city_id":324,"city_name":"成都","province_id":26,"province_name":"四川"},{"city_id":394,"city_name":"重庆","province_id":32,"province_name":"重庆"},{"city_id":199,"city_name":"长沙","province_id":14,"province_name":"湖南"},{"city_id":214,"city_name":"长春","province_id":15,"province_name":"吉林"},{"city_id":100,"city_name":"崇左","province_id":7,"province_name":"广西"},{"city_id":123,"city_name":"昌江","province_id":9,"province_name":"海南"},{"city_id":124,"city_name":"澄迈县","province_id":9,"province_name":"海南"},{"city_id":140,"city_name":"沧州","province_id":10,"province_name":"河北"},{"city_id":141,"city_name":"承德","province_id":10,"province_name":"河北"},{"city_id":198,"city_name":"常德","province_id":14,"province_name":"湖南"},{"city_id":40,"city_name":"滁州","province_id":2,"province_name":"安徽"},{"city_id":200,"city_name":"郴州","province_id":14,"province_name":"湖南"},{"city_id":77,"city_name":"潮州","province_id":6,"province_name":"广东"},{"city_id":221,"city_name":"常州","province_id":16,"province_name":"江苏"},{"city_id":247,"city_name":"朝阳","province_id":18,"province_name":"辽宁"},{"city_id":262,"city_name":"赤峰","province_id":19,"province_name":"内蒙古"},{"city_id":300,"city_name":"长治","province_id":23,"province_name":"山西"},{"city_id":38,"city_name":"巢湖","province_id":2,"province_name":"安徽"},{"city_id":345,"city_name":"昌都","province_id":28,"province_name":"西藏"},{"city_id":355,"city_name":"昌吉","province_id":29,"province_name":"新疆"},{"city_id":368,"city_name":"楚雄","province_id":30,"province_name":"云南"},{"city_id":39,"city_name":"池州","province_id":2,"province_name":"安徽"},{"city_id":4569,"city_name":"长白山","province_id":15,"province_name":"吉林"}],"begin_key":"C"},{"city_list":[{"city_id":248,"city_name":"大连","province_id":18,"province_name":"辽宁"},{"city_id":369,"city_name":"大理","province_id":30,"province_name":"云南"},{"city_id":78,"city_name":"东莞","province_id":6,"province_name":"广东"},{"city_id":126,"city_name":"东方","province_id":9,"province_name":"海南"},{"city_id":168,"city_name":"大庆","province_id":12,"province_name":"黑龙江"},{"city_id":169,"city_name":"大兴安岭","province_id":12,"province_name":"黑龙江"},{"city_id":64,"city_name":"定西","province_id":5,"province_name":"甘肃"},{"city_id":249,"city_name":"丹东","province_id":18,"province_name":"辽宁"},{"city_id":284,"city_name":"德州","province_id":22,"province_name":"山东"},{"city_id":285,"city_name":"东营","province_id":22,"province_name":"山东"},{"city_id":301,"city_name":"大同","province_id":23,"province_name":"山西"},{"city_id":325,"city_name":"达州","province_id":26,"province_name":"四川"},{"city_id":326,"city_name":"德阳","province_id":26,"province_name":"四川"},{"city_id":125,"city_name":"定安县","province_id":9,"province_name":"海南"},{"city_id":370,"city_name":"德宏","province_id":30,"province_name":"云南"},{"city_id":371,"city_name":"迪庆","province_id":30,"province_name":"云南"}],"begin_key":"D"},{"city_list":[{"city_id":181,"city_name":"鄂州","province_id":13,"province_name":"湖北"},{"city_id":182,"city_name":"恩施","province_id":13,"province_name":"湖北"},{"city_id":263,"city_name":"鄂尔多斯","province_id":19,"province_name":"内蒙古"}],"begin_key":"E"},{"city_list":[{"city_id":41,"city_name":"阜阳","province_id":2,"province_name":"安徽"},{"city_id":54,"city_name":"福州","province_id":4,"province_name":"福建"},{"city_id":79,"city_name":"佛山","province_id":6,"province_name":"广东"},{"city_id":101,"city_name":"防城港","province_id":7,"province_name":"广西"},{"city_id":234,"city_name":"抚州","province_id":17,"province_name":"江西"},{"city_id":250,"city_name":"抚顺","province_id":18,"province_name":"辽宁"},{"city_id":251,"city_name":"阜新","province_id":18,"province_name":"辽宁"}],"begin_key":"F"},{"city_list":[{"city_id":102,"city_name":"桂林","province_id":7,"province_name":"广西"},{"city_id":80,"city_name":"广州","province_id":6,"province_name":"广东"},{"city_id":65,"city_name":"甘南","province_id":5,"province_name":"甘肃"},{"city_id":103,"city_name":"贵港","province_id":7,"province_name":"广西"},{"city_id":114,"city_name":"贵阳","province_id":8,"province_name":"贵州"},{"city_id":235,"city_name":"赣州","province_id":17,"province_name":"江西"},{"city_id":271,"city_name":"固原","province_id":20,"province_name":"宁夏"},{"city_id":275,"city_name":"果洛","province_id":21,"province_name":"青海"},{"city_id":327,"city_name":"甘孜","province_id":26,"province_name":"四川"},{"city_id":328,"city_name":"广安","province_id":26,"province_name":"四川"},{"city_id":329,"city_name":"广元","province_id":26,"province_name":"四川"},{"city_id":397,"city_name":"高雄","province_id":35,"province_name":"台湾"}],"begin_key":"G"},{"city_list":[{"city_id":383,"city_name":"杭州","province_id":31,"province_name":"浙江"},{"city_id":142,"city_name":"邯郸","province_id":10,"province_name":"河北"},{"city_id":45,"city_name":"黄山","province_id":2,"province_name":"安徽"},{"city_id":127,"city_name":"海口","province_id":9,"province_name":"海南"},{"city_id":286,"city_name":"菏泽","province_id":22,"province_name":"山东"},{"city_id":252,"city_name":"葫芦岛","province_id":18,"province_name":"辽宁"},{"city_id":104,"city_name":"河池","province_id":7,"province_name":"广西"},{"city_id":105,"city_name":"贺州","province_id":7,"province_name":"广西"},{"city_id":44,"city_name":"淮南","province_id":2,"province_name":"安徽"},{"city_id":43,"city_name":"淮北","province_id":2,"province_name":"安徽"},{"city_id":143,"city_name":"衡水","province_id":10,"province_name":"河北"},{"city_id":151,"city_name":"鹤壁","province_id":11,"province_name":"河南"},{"city_id":170,"city_name":"哈尔滨","province_id":12,"province_name":"黑龙江"},{"city_id":171,"city_name":"鹤岗","province_id":12,"province_name":"黑龙江"},{"city_id":172,"city_name":"黑河","province_id":12,"province_name":"黑龙江"},{"city_id":183,"city_name":"黄冈","province_id":13,"province_name":"湖北"},{"city_id":184,"city_name":"黄石","province_id":13,"province_name":"湖北"},{"city_id":201,"city_name":"衡阳","province_id":14,"province_name":"湖南"},{"city_id":202,"city_name":"怀化","province_id":14,"province_name":"湖南"},{"city_id":222,"city_name":"淮安","province_id":16,"province_name":"江苏"},{"city_id":82,"city_name":"惠州","province_id":6,"province_name":"广东"},{"city_id":264,"city_name":"呼和浩特","province_id":19,"province_name":"内蒙古"},{"city_id":265,"city_name":"呼伦贝尔","province_id":19,"province_name":"内蒙古"},{"city_id":276,"city_name":"海北","province_id":21,"province_name":"青海"},{"city_id":277,"city_name":"海东","province_id":21,"province_name":"青海"},{"city_id":278,"city_name":"海南藏族","province_id":21,"province_name":"青海"},{"city_id":279,"city_name":"海西","province_id":21,"province_name":"青海"},{"city_id":280,"city_name":"黄南","province_id":21,"province_name":"青海"},{"city_id":81,"city_name":"河源","province_id":6,"province_name":"广东"},{"city_id":313,"city_name":"汉中","province_id":24,"province_name":"陕西"},{"city_id":356,"city_name":"哈密","province_id":29,"province_name":"新疆"},{"city_id":357,"city_name":"和田","province_id":29,"province_name":"新疆"},{"city_id":372,"city_name":"红河","province_id":30,"province_name":"云南"},{"city_id":42,"city_name":"合肥","province_id":2,"province_name":"安徽"},{"city_id":384,"city_name":"湖州","province_id":31,"province_name":"浙江"},{"city_id":398,"city_name":"花莲","province_id":35,"province_name":"台湾"}],"begin_key":"H"},{"city_list":[{"city_id":287,"city_name":"济南","province_id":22,"province_name":"山东"},{"city_id":215,"city_name":"吉林","province_id":15,"province_name":"吉林"},{"city_id":385,"city_name":"嘉兴","province_id":31,"province_name":"浙江"},{"city_id":238,"city_name":"九江","province_id":17,"province_name":"江西"},{"city_id":153,"city_name":"焦作","province_id":11,"province_name":"河南"},{"city_id":186,"city_name":"荆州","province_id":13,"province_name":"湖北"},{"city_id":84,"city_name":"揭阳","province_id":6,"province_name":"广东"},{"city_id":173,"city_name":"鸡西","province_id":12,"province_name":"黑龙江"},{"city_id":174,"city_name":"佳木斯","province_id":12,"province_name":"黑龙江"},{"city_id":185,"city_name":"荆门","province_id":13,"province_name":"湖北"},{"city_id":152,"city_name":"济源","province_id":11,"province_name":"河南"},{"city_id":67,"city_name":"金昌","province_id":5,"province_name":"甘肃"},{"city_id":236,"city_name":"吉安","province_id":17,"province_name":"江西"},{"city_id":237,"city_name":"景德镇","province_id":17,"province_name":"江西"},{"city_id":83,"city_name":"江门","province_id":6,"province_name":"广东"},{"city_id":253,"city_name":"锦州","province_id":18,"province_name":"辽宁"},{"city_id":66,"city_name":"嘉峪关","province_id":5,"province_name":"甘肃"},{"city_id":288,"city_name":"济宁","province_id":22,"province_name":"山东"},{"city_id":302,"city_name":"晋城","province_id":23,"province_name":"山西"},{"city_id":303,"city_name":"晋中","province_id":23,"province_name":"山西"},{"city_id":68,"city_name":"酒泉","province_id":5,"province_name":"甘肃"},{"city_id":386,"city_name":"金华","province_id":31,"province_name":"浙江"},{"city_id":399,"city_name":"基隆","province_id":35,"province_name":"台湾"},{"city_id":400,"city_name":"嘉义","province_id":35,"province_name":"台湾"},{"city_id":5127,"city_name":"金门","province_id":35,"province_name":"台湾"}],"begin_key":"J"},{"city_list":[{"city_id":373,"city_name":"昆明","province_id":30,"province_name":"云南"},{"city_id":154,"city_name":"开封","province_id":11,"province_name":"河南"},{"city_id":359,"city_name":"克拉玛依","province_id":29,"province_name":"新疆"},{"city_id":360,"city_name":"克孜勒苏柯尔克孜","province_id":29,"province_name":"新疆"},{"city_id":358,"city_name":"喀什","province_id":29,"province_name":"新疆"}],"begin_key":"K"},{"city_list":[{"city_id":346,"city_name":"拉萨","province_id":28,"province_name":"西藏"},{"city_id":155,"city_name":"洛阳","province_id":11,"province_name":"河南"},{"city_id":69,"city_name":"兰州","province_id":5,"province_name":"甘肃"},{"city_id":330,"city_name":"乐山","province_id":26,"province_name":"四川"},{"city_id":374,"city_name":"丽江","province_id":30,"province_name":"云南"},{"city_id":387,"city_name":"丽水","province_id":31,"province_name":"浙江"},{"city_id":291,"city_name":"临沂","province_id":22,"province_name":"山东"},{"city_id":115,"city_name":"六盘水","province_id":8,"province_name":"贵州"},{"city_id":128,"city_name":"乐东","province_id":9,"province_name":"海南"},{"city_id":129,"city_name":"临高县","province_id":9,"province_name":"海南"},{"city_id":130,"city_name":"陵水","province_id":9,"province_name":"海南"},{"city_id":144,"city_name":"廊坊","province_id":10,"province_name":"河北"},{"city_id":55,"city_name":"龙岩","province_id":4,"province_name":"福建"},{"city_id":203,"city_name":"娄底","province_id":14,"province_name":"湖南"},{"city_id":216,"city_name":"辽源","province_id":15,"province_name":"吉林"},{"city_id":223,"city_name":"连云港","province_id":16,"province_name":"江苏"},{"city_id":254,"city_name":"辽阳","province_id":18,"province_name":"辽宁"},{"city_id":289,"city_name":"莱芜","province_id":22,"province_name":"山东"},{"city_id":290,"city_name":"聊城","province_id":22,"province_name":"山东"},{"city_id":107,"city_name":"柳州","province_id":7,"province_name":"广西"},{"city_id":304,"city_name":"临汾","province_id":23,"province_name":"山西"},{"city_id":305,"city_name":"吕梁","province_id":23,"province_name":"山西"},{"city_id":70,"city_name":"临夏","province_id":5,"province_name":"甘肃"},{"city_id":331,"city_name":"凉山","province_id":26,"province_name":"四川"},{"city_id":46,"city_name":"六安","province_id":2,"province_name":"安徽"},{"city_id":347,"city_name":"林芝","province_id":28,"province_name":"西藏"},{"city_id":71,"city_name":"陇南","province_id":5,"province_name":"甘肃"},{"city_id":375,"city_name":"临沧","province_id":30,"province_name":"云南"},{"city_id":106,"city_name":"来宾","province_id":7,"province_name":"广西"}],"begin_key":"L"},{"city_list":[{"city_id":175,"city_name":"牡丹江","province_id":12,"province_name":"黑龙江"},{"city_id":85,"city_name":"茂名","province_id":6,"province_name":"广东"},{"city_id":86,"city_name":"梅州","province_id":6,"province_name":"广东"},{"city_id":47,"city_name":"马鞍山","province_id":2,"province_name":"安徽"},{"city_id":332,"city_name":"眉山","province_id":26,"province_name":"四川"},{"city_id":333,"city_name":"绵阳","province_id":26,"province_name":"四川"},{"city_id":5117,"city_name":"苗栗","province_id":35,"province_name":"台湾"}],"begin_key":"M"},{"city_list":[{"city_id":224,"city_name":"南京","province_id":16,"province_name":"江苏"},{"city_id":108,"city_name":"南宁","province_id":7,"province_name":"广西"},{"city_id":57,"city_name":"宁德","province_id":4,"province_name":"福建"},{"city_id":156,"city_name":"南阳","province_id":11,"province_name":"河南"},{"city_id":56,"city_name":"南平","province_id":4,"province_name":"福建"},{"city_id":225,"city_name":"南通","province_id":16,"province_name":"江苏"},{"city_id":239,"city_name":"南昌","province_id":17,"province_name":"江西"},{"city_id":334,"city_name":"南充","province_id":26,"province_name":"四川"},{"city_id":335,"city_name":"内江","province_id":26,"province_name":"四川"},{"city_id":348,"city_name":"那曲","province_id":28,"province_name":"西藏"},{"city_id":376,"city_name":"怒江","province_id":30,"province_name":"云南"},{"city_id":388,"city_name":"宁波","province_id":31,"province_name":"浙江"},{"city_id":5119,"city_name":"南投","province_id":35,"province_name":"台湾"}],"begin_key":"N"},{"city_list":[{"city_id":58,"city_name":"莆田","province_id":4,"province_name":"福建"},{"city_id":72,"city_name":"平凉","province_id":5,"province_name":"甘肃"},{"city_id":157,"city_name":"平顶山","province_id":11,"province_name":"河南"},{"city_id":240,"city_name":"萍乡","province_id":17,"province_name":"江西"},{"city_id":255,"city_name":"盘锦","province_id":18,"province_name":"辽宁"},{"city_id":336,"city_name":"攀枝花","province_id":26,"province_name":"四川"},{"city_id":378,"city_name":"普洱","province_id":30,"province_name":"云南"},{"city_id":5121,"city_name":"屏东","province_id":35,"province_name":"台湾"},{"city_id":5130,"city_name":"澎湖","province_id":35,"province_name":"台湾"}],"begin_key":"P"},{"city_list":[{"city_id":292,"city_name":"青岛","province_id":22,"province_name":"山东"},{"city_id":145,"city_name":"秦皇岛","province_id":10,"province_name":"河北"},{"city_id":116,"city_name":"黔东南","province_id":8,"province_name":"贵州"},{"city_id":109,"city_name":"钦州","province_id":7,"province_name":"广西"},{"city_id":87,"city_name":"清远","province_id":6,"province_name":"广东"},{"city_id":117,"city_name":"黔南","province_id":8,"province_name":"贵州"},{"city_id":118,"city_name":"黔西南","province_id":8,"province_name":"贵州"},{"city_id":131,"city_name":"琼海","province_id":9,"province_name":"海南"},{"city_id":132,"city_name":"琼中","province_id":9,"province_name":"海南"},{"city_id":73,"city_name":"庆阳","province_id":5,"province_name":"甘肃"},{"city_id":176,"city_name":"七台河","province_id":12,"province_name":"黑龙江"},{"city_id":177,"city_name":"齐齐哈尔","province_id":12,"province_name":"黑龙江"},{"city_id":187,"city_name":"潜江","province_id":13,"province_name":"湖北"},{"city_id":59,"city_name":"泉州","province_id":4,"province_name":"福建"},{"city_id":377,"city_name":"曲靖","province_id":30,"province_name":"云南"}],"begin_key":"Q"},{"city_list":[{"city_id":293,"city_name":"日照","province_id":22,"province_name":"山东"},{"city_id":349,"city_name":"日喀则","province_id":28,"province_name":"西藏"}],"begin_key":"R"},{"city_list":[{"city_id":321,"city_name":"上海","province_id":25,"province_name":"上海"},{"city_id":133,"city_name":"三亚","province_id":9,"province_name":"海南"},{"city_id":256,"city_name":"沈阳","province_id":18,"province_name":"辽宁"},{"city_id":91,"city_name":"深圳","province_id":6,"province_name":"广东"},{"city_id":226,"city_name":"苏州","province_id":16,"province_name":"江苏"},{"city_id":389,"city_name":"绍兴","province_id":31,"province_name":"浙江"},{"city_id":241,"city_name":"上饶","province_id":17,"province_name":"江西"},{"city_id":88,"city_name":"汕头","province_id":6,"province_name":"广东"},{"city_id":189,"city_name":"十堰","province_id":13,"province_name":"湖北"},{"city_id":158,"city_name":"三门峡","province_id":11,"province_name":"河南"},{"city_id":361,"city_name":"石河子","province_id":29,"province_name":"新疆"},{"city_id":179,"city_name":"绥化","province_id":12,"province_name":"黑龙江"},{"city_id":188,"city_name":"神农架林区","province_id":13,"province_name":"湖北"},{"city_id":159,"city_name":"商丘","province_id":11,"province_name":"河南"},{"city_id":190,"city_name":"随州","province_id":13,"province_name":"湖北"},{"city_id":204,"city_name":"邵阳","province_id":14,"province_name":"湖南"},{"city_id":217,"city_name":"四平","province_id":15,"province_name":"吉林"},{"city_id":218,"city_name":"松原","province_id":15,"province_name":"吉林"},{"city_id":90,"city_name":"韶关","province_id":6,"province_name":"广东"},{"city_id":227,"city_name":"宿迁","province_id":16,"province_name":"江苏"},{"city_id":60,"city_name":"三明","province_id":4,"province_name":"福建"},{"city_id":146,"city_name":"石家庄","province_id":10,"province_name":"河北"},{"city_id":272,"city_name":"石嘴山","province_id":20,"province_name":"宁夏"},{"city_id":306,"city_name":"朔州","province_id":23,"province_name":"山西"},{"city_id":314,"city_name":"商洛","province_id":24,"province_name":"陕西"},{"city_id":48,"city_name":"宿州","province_id":2,"province_name":"安徽"},{"city_id":337,"city_name":"遂宁","province_id":26,"province_name":"四川"},{"city_id":350,"city_name":"山南","province_id":28,"province_name":"西藏"},{"city_id":178,"city_name":"双鸭山","province_id":12,"province_name":"黑龙江"},{"city_id":89,"city_name":"汕尾","province_id":6,"province_name":"广东"},{"city_id":6321,"city_name":"三沙市","province_id":9,"province_name":"海南"}],"begin_key":"S"},{"city_list":[{"city_id":343,"city_name":"天津","province_id":27,"province_name":"天津"},{"city_id":401,"city_name":"台北","province_id":35,"province_name":"台湾"},{"city_id":307,"city_name":"太原","province_id":23,"province_name":"山西"},{"city_id":119,"city_name":"铜仁","province_id":8,"province_name":"贵州"},{"city_id":147,"city_name":"唐山","province_id":10,"province_name":"河北"},{"city_id":191,"city_name":"天门","province_id":13,"province_name":"湖北"},{"city_id":219,"city_name":"通化","province_id":15,"province_name":"吉林"},{"city_id":228,"city_name":"泰州","province_id":16,"province_name":"江苏"},{"city_id":257,"city_name":"铁岭","province_id":18,"province_name":"辽宁"},{"city_id":266,"city_name":"通辽","province_id":19,"province_name":"内蒙古"},{"city_id":294,"city_name":"泰安","province_id":22,"province_name":"山东"},{"city_id":134,"city_name":"屯昌县","province_id":9,"province_name":"海南"},{"city_id":315,"city_name":"铜川","province_id":24,"province_name":"陕西"},{"city_id":49,"city_name":"铜陵","province_id":2,"province_name":"安徽"},{"city_id":362,"city_name":"图木舒克","province_id":29,"province_name":"新疆"},{"city_id":363,"city_name":"吐鲁番","province_id":29,"province_name":"新疆"},{"city_id":390,"city_name":"台州","province_id":31,"province_name":"浙江"},{"city_id":74,"city_name":"天水","province_id":5,"province_name":"甘肃"},{"city_id":402,"city_name":"台东","province_id":35,"province_name":"台湾"},{"city_id":403,"city_name":"台南","province_id":35,"province_name":"台湾"},{"city_id":404,"city_name":"台中","province_id":35,"province_name":"台湾"},{"city_id":3113,"city_name":"塔城","province_id":29,"province_name":"新疆"},{"city_id":5116,"city_name":"桃园","province_id":35,"province_name":"台湾"}],"begin_key":"T"},{"city_list":[{"city_id":192,"city_name":"武汉","province_id":13,"province_name":"湖北"},{"city_id":137,"city_name":"五指山","province_id":9,"province_name":"海南"},{"city_id":364,"city_name":"乌鲁木齐","province_id":29,"province_name":"新疆"},{"city_id":295,"city_name":"威海","province_id":22,"province_name":"山东"},{"city_id":50,"city_name":"芜湖","province_id":2,"province_name":"安徽"},{"city_id":296,"city_name":"潍坊","province_id":22,"province_name":"山东"},{"city_id":3143,"city_name":"乌苏里江","province_id":12,"province_name":"黑龙江"},{"city_id":75,"city_name":"武威","province_id":5,"province_name":"甘肃"},{"city_id":267,"city_name":"乌海","province_id":19,"province_name":"内蒙古"},{"city_id":268,"city_name":"乌兰察布市","province_id":19,"province_name":"内蒙古"},{"city_id":273,"city_name":"吴忠","province_id":20,"province_name":"宁夏"},{"city_id":135,"city_name":"万宁","province_id":9,"province_name":"海南"},{"city_id":229,"city_name":"无锡","province_id":16,"province_name":"江苏"},{"city_id":316,"city_name":"渭南","province_id":24,"province_name":"陕西"},{"city_id":110,"city_name":"梧州","province_id":7,"province_name":"广西"},{"city_id":365,"city_name":"五家渠","province_id":29,"province_name":"新疆"},{"city_id":379,"city_name":"文山","province_id":30,"province_name":"云南"},{"city_id":391,"city_name":"温州","province_id":31,"province_name":"浙江"},{"city_id":136,"city_name":"文昌","province_id":9,"province_name":"海南"}],"begin_key":"W"},{"city_list":[{"city_id":61,"city_name":"厦门","province_id":4,"province_name":"福建"},{"city_id":317,"city_name":"西安","province_id":24,"province_name":"陕西"},{"city_id":148,"city_name":"邢台","province_id":10,"province_name":"河北"},{"city_id":380,"city_name":"西双版纳","province_id":30,"province_name":"云南"},{"city_id":281,"city_name":"西宁","province_id":21,"province_name":"青海"},{"city_id":161,"city_name":"信阳","province_id":11,"province_name":"河南"},{"city_id":160,"city_name":"新乡","province_id":11,"province_name":"河南"},{"city_id":194,"city_name":"咸宁","province_id":13,"province_name":"湖北"},{"city_id":195,"city_name":"襄阳","province_id":13,"province_name":"湖北"},{"city_id":196,"city_name":"孝感","province_id":13,"province_name":"湖北"},{"city_id":205,"city_name":"湘潭","province_id":14,"province_name":"湖南"},{"city_id":206,"city_name":"湘西","province_id":14,"province_name":"湖南"},{"city_id":230,"city_name":"徐州","province_id":16,"province_name":"江苏"},{"city_id":242,"city_name":"新余","province_id":17,"province_name":"江西"},{"city_id":269,"city_name":"锡林郭勒盟","province_id":19,"province_name":"内蒙古"},{"city_id":270,"city_name":"兴安盟","province_id":19,"province_name":"内蒙古"},{"city_id":162,"city_name":"许昌","province_id":11,"province_name":"河南"},{"city_id":308,"city_name":"忻州","province_id":23,"province_name":"山西"},{"city_id":51,"city_name":"宣城","province_id":2,"province_name":"安徽"},{"city_id":318,"city_name":"咸阳","province_id":24,"province_name":"陕西"},{"city_id":193,"city_name":"仙桃","province_id":13,"province_name":"湖北"},{"city_id":4580,"city_name":"兴城","province_id":18,"province_name":"辽宁"},{"city_id":5114,"city_name":"新竹","province_id":35,"province_name":"台湾"}],"begin_key":"X"},{"city_list":[{"city_id":297,"city_name":"烟台","province_id":22,"province_name":"山东"},{"city_id":232,"city_name":"扬州","province_id":16,"province_name":"江苏"},{"city_id":243,"city_name":"宜春","province_id":17,"province_name":"江西"},{"city_id":319,"city_name":"延安","province_id":24,"province_name":"陕西"},{"city_id":197,"city_name":"宜昌","province_id":13,"province_name":"湖北"},{"city_id":320,"city_name":"榆林","province_id":24,"province_name":"陕西"},{"city_id":339,"city_name":"宜宾","province_id":26,"province_name":"四川"},{"city_id":274,"city_name":"银川","province_id":20,"province_name":"宁夏"},{"city_id":220,"city_name":"延边","province_id":15,"province_name":"吉林"},{"city_id":231,"city_name":"盐城","province_id":16,"province_name":"江苏"},{"city_id":93,"city_name":"云浮","province_id":6,"province_name":"广东"},{"city_id":111,"city_name":"玉林","province_id":7,"province_name":"广西"},{"city_id":244,"city_name":"鹰潭","province_id":17,"province_name":"江西"},{"city_id":258,"city_name":"营口","province_id":18,"province_name":"辽宁"},{"city_id":209,"city_name":"岳阳","province_id":14,"province_name":"湖南"},{"city_id":282,"city_name":"玉树","province_id":21,"province_name":"青海"},{"city_id":92,"city_name":"阳江","province_id":6,"province_name":"广东"},{"city_id":309,"city_name":"阳泉","province_id":23,"province_name":"山西"},{"city_id":310,"city_name":"运城","province_id":23,"province_name":"山西"},{"city_id":180,"city_name":"伊春","province_id":12,"province_name":"黑龙江"},{"city_id":207,"city_name":"益阳","province_id":14,"province_name":"湖南"},{"city_id":338,"city_name":"雅安","province_id":26,"province_name":"四川"},{"city_id":208,"city_name":"永州","province_id":14,"province_name":"湖南"},{"city_id":366,"city_name":"伊犁","province_id":29,"province_name":"新疆"},{"city_id":381,"city_name":"玉溪","province_id":30,"province_name":"云南"},{"city_id":5115,"city_name":"宜兰","province_id":35,"province_name":"台湾"},{"city_id":5120,"city_name":"云林","province_id":35,"province_name":"台湾"}],"begin_key":"Y"},{"city_list":[{"city_id":163,"city_name":"郑州","province_id":11,"province_name":"河南"},{"city_id":97,"city_name":"珠海","province_id":6,"province_name":"广东"},{"city_id":210,"city_name":"张家界","province_id":14,"province_name":"湖南"},{"city_id":120,"city_name":"遵义","province_id":8,"province_name":"贵州"},{"city_id":94,"city_name":"湛江","province_id":6,"province_name":"广东"},{"city_id":95,"city_name":"肇庆","province_id":6,"province_name":"广东"},{"city_id":299,"city_name":"淄博","province_id":22,"province_name":"山东"},{"city_id":96,"city_name":"中山","province_id":6,"province_name":"广东"},{"city_id":138,"city_name":"儋州","province_id":9,"province_name":"海南"},{"city_id":149,"city_name":"张家口","province_id":10,"province_name":"河北"},{"city_id":52,"city_name":"亳州","province_id":2,"province_name":"安徽"},{"city_id":164,"city_name":"周口","province_id":11,"province_name":"河南"},{"city_id":165,"city_name":"驻马店","province_id":11,"province_name":"河南"},{"city_id":166,"city_name":"漯河","province_id":11,"province_name":"河南"},{"city_id":167,"city_name":"濮阳","province_id":11,"province_name":"河南"},{"city_id":76,"city_name":"张掖","province_id":5,"province_name":"甘肃"},{"city_id":211,"city_name":"株洲","province_id":14,"province_name":"湖南"},{"city_id":233,"city_name":"镇江","province_id":16,"province_name":"江苏"},{"city_id":298,"city_name":"枣庄","province_id":22,"province_name":"山东"},{"city_id":62,"city_name":"漳州","province_id":4,"province_name":"福建"},{"city_id":340,"city_name":"资阳","province_id":26,"province_name":"四川"},{"city_id":341,"city_name":"自贡","province_id":26,"province_name":"四川"},{"city_id":342,"city_name":"泸州","province_id":26,"province_name":"四川"},{"city_id":382,"city_name":"昭通","province_id":30,"province_name":"云南"},{"city_id":392,"city_name":"舟山","province_id":31,"province_name":"浙江"},{"city_id":393,"city_name":"衢州","province_id":31,"province_name":"浙江"},{"city_id":3105,"city_name":"中卫","province_id":20,"province_name":"宁夏"},{"city_id":5118,"city_name":"彰化","province_id":35,"province_name":"台湾"}],"begin_key":"Z"}]
     * msg :
     * result_count : 23
     */

    private int status;
    private int page_total;
    private int pagenumber;
    private String msg;
    private int result_count;
    /**
     * city_list : [{"city_id":53,"city_name":"北京","province_id":3,"province_name":"北京"},{"city_id":321,"city_name":"上海","province_id":25,"province_name":"上海"},{"city_id":80,"city_name":"广州","province_id":6,"province_name":"广东"},{"city_id":91,"city_name":"深圳","province_id":6,"province_name":"广东"},{"city_id":383,"city_name":"杭州","province_id":31,"province_name":"浙江"},{"city_id":324,"city_name":"成都","province_id":26,"province_name":"四川"},{"city_id":394,"city_name":"重庆","province_id":32,"province_name":"重庆"},{"city_id":192,"city_name":"武汉","province_id":13,"province_name":"湖北"},{"city_id":317,"city_name":"西安","province_id":24,"province_name":"陕西"},{"city_id":199,"city_name":"长沙","province_id":14,"province_name":"湖南"},{"city_id":226,"city_name":"苏州","province_id":16,"province_name":"江苏"},{"city_id":224,"city_name":"南京","province_id":16,"province_name":"江苏"},{"city_id":248,"city_name":"大连","province_id":18,"province_name":"辽宁"},{"city_id":256,"city_name":"沈阳","province_id":18,"province_name":"辽宁"},{"city_id":292,"city_name":"青岛","province_id":22,"province_name":"山东"}]
     * begin_key : hot
     */

    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult_count() {
        return result_count;
    }

    public void setResult_count(int result_count) {
        this.result_count = result_count;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        private String begin_key;
        /**
         * city_id : 53
         * city_name : 北京
         * province_id : 3
         * province_name : 北京
         */

        private List<CityListBean> city_list;

        public String getBegin_key() {
            return begin_key;
        }

        public void setBegin_key(String begin_key) {
            this.begin_key = begin_key;
        }

        public List<CityListBean> getCity_list() {
            return city_list;
        }

        public void setCity_list(List<CityListBean> city_list) {
            this.city_list = city_list;
        }

        public static class CityListBean implements Serializable{
            private int city_id;
            private String city_name;
            private int province_id;
            private String province_name;

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public int getProvince_id() {
                return province_id;
            }

            public void setProvince_id(int province_id) {
                this.province_id = province_id;
            }

            public String getProvince_name() {
                return province_name;
            }

            public void setProvince_name(String province_name) {
                this.province_name = province_name;
            }
        }
    }
}
