/**
 * Created by Administrator on 2018/12/7.
 */
var timer;
$(".menu-item").hover(function () {
    $(".sub-nav").hide()
    $(this).children(".sub-nav").show()
    $(".hover-bg").slideDown()
},function () {
    timer = setTimeout(function () {
        $(this).children(".sub-nav").hide()
    },500)
})

$(".sub-nav").hover(function () {
    clearTimeout(timer)
})

$(".nav").hover(function () {

},function () {
    $(".hover-bg").hide()
    $(".sub-nav").hide()
})