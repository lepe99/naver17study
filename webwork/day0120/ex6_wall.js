$(() => {
    // 벽지 이미지 클릭 시 이벤트
    $("ul.list img").click((e) => {
        // 부모태그인 li 에 active 클래스 추가
        $(e.target).parent().addClass("active");
        // 부모(li)의 형제들의 active 클래스 제거
        $(e.target).parent().siblings().removeClass("active");
        // 클릭한 이미지의 title 얻기
        let title = $(e.target).attr("title");
        // title을 h1.title에 넣기
        $("h1.title").text(title);
        // 이미지 src 얻기
        let src = $(e.target).attr("src");
        // 이미지 src를 .wall 에 background-image 형태로 넣기
        $(".wall").css("background-image", `url(${src})`);
    });
});