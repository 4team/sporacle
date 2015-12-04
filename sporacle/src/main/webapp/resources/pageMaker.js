/**
 * Created by Bitcamp on 2015-12-04.
 */
console.log("Hello World");

function makePage(criteria){
    var startPage, endPage,prev,next;
    var str = "";
    var pageNo = criteria.pageNo;

    endPage = Math.ceil(pageNo/10.0)*10;
    startPage = endPage - 9;
    var tempLast = Math.ceil(criteria.totalCount/criteria.perPage);
    console.log('템프 라스트 : '+tempLast);
    console.log('시작페이지: '+startPage,'  마지막페이지: '+endPage);

    endPage = tempLast < endPage ? tempLast:endPage;

    console.log('IF 후 시작페이지: '+startPage,'  마지막페이지: '+endPage);
    prev = startPage == 1? false:true;
    next = tempLast > endPage? true:false;

    if(prev){
        str +="<li><a href='/board/list?pageNo="+(startPage-1)+"'> << </a></li>";
    }
    for(var i = startPage; i<=endPage; i++){
        str +="<li><a href='/board/list?pageNo="+i+"' target='_self'>"+ i +"</a></li>";
    }
    if(next){
        str +="<li><a href='/board/list?pageNo="+(endPage+1)+"'> >> </a></li>";
    }

    return str;
}

