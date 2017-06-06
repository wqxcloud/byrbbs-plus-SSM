(function($){
    var ms = {
        init:function(totalsubpageTmep,args){
            return (function(){
                ms.fillHtml(totalsubpageTmep,args);
                ms.bindEvent(totalsubpageTmep,args);
            })();
        },
        //填充html
        fillHtml:function(totalsubpageTmep,args){
            return (function(){
                totalsubpageTmep="";
                /************************START*********************/
                if(args.currPage > 1){
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >prev</a></li>";
                }else{
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >prev</a></li>";
                }

                // 页码大于等于4的时候，添加第一个页码元素
                if(args.currPage!=1 && args.currPage>=4 && args.totalPage!=4) {
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >"+1+"</a></li>";
                }
				/* 当前页码>4, 并且<=总页码，总页码>5，添加“···”*/
                if(args.currPage-2>2 && args.currPage<=args.totalPage && args.totalPage>5) {
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_' data-go='' >...</a></li>";
                }
				/* 当前页码的前两页 */
                var start = args.currPage-2;
				/* 当前页码的后两页 */
                var end = args.currPage+2;

                if((start>1 && args.currPage<4) || args.currPage==1) {
                    end++;
                }
                if(args.currPage>args.totalPage-4 && args.currPage>=args.totalPage) {
                    start--;
                }

                for(; start<=end; start++) {
                    if(start<=args.totalPage && start>=1) {
                        if(start != args.currPage) {
                            totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >"+start+"</a></li>";
                        }else{
                            totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >"+start+"</a></li>";
                        }
                    }
                }

                if(args.currPage+2<args.totalPage-1 && args.currPage>=1 && args.totalPage>5) {
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_' data-go='' >...</a></li>";
                }

                if(args.currPage!=args.totalPage && args.currPage<args.totalPage-2 && args.totalPage!=4) {
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >"+args.totalPage+"</a></li>";
                }

                if(args.current < args.totalPage){
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >next</a></li>";
                }else{
                    totalsubpageTmep += "<li class='ali'><a href='javascript:void(0);' class='geraltTb_pager' data-go='' >next</a></li>";
                }
                $(".pagination").html(totalsubpageTmep);
            })();
        },
        //绑定事件
        bindEvent:function(totalsubpageTmep,args){
            return (function(){
                totalsubpageTmep.on("click","a.geraltTb_pager",function(event){
                    var current = parseInt($(this).text());
                    //判断是否是上一页
                    if($(this).hasClass("prev")){
                        $('.page a').each(function(index,value){
                            if($('.page a').eq(index).hasClass("now")&&index!=1){
                                var num = $('.page a').eq(index).parent()[0].id;
                                current = num.split("_")[1]-1;
                                return false;
                            }
                            else{
                                current=1;
                            }
                        });
                    }
                    //判断是否是下一页
                    if($(this).hasClass("next")){
                        $('.page a').each(function(index,value){
                            if($('.page a').eq(index).hasClass("now")){
                                var num = $('.page a').eq(index).parent()[0].id;
                                if(num.split("_")[1]!=args.totalPage){
                                    current=num.split("_"[1]);
                                    current++;
                                }
                                return false;
                            }else{
                                current=1;
                            }
                        });
                    }
                    ms.fillHtml(totalsubpageTmep,{"currPage":current,"totalPage":args.totalPage,"turndown":args.turndown});
                    $('#pageNUm_'+current+' a').eq(0).attr("class","geraltTb_pager now");
                    console.log($('#pageNUm_'+current))

                    if(typeof(args.backFn)=="function"){
                        args.backFn(current);
                    }
                });
            })();



        }
    }
    $.fn.createPage = function(options){
        ms.init(this,options);
    }
})(jQuery);
