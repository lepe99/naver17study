$(() => {
    // h1.title 클릭 시 .musicList slideToggle 효과
    $('h1.title').click(() => {
        $("ul.musicList").slideToggle('slow');
    });
    // 노래제목 클릭 시 이벤트
    $("ul.musicList").click((e) => {
        // 노래제목 얻기
        let title = $(e.target).text();
        // h1.title에 넣기
        $("h1.title").text(title);
        // 클릭한 곳의 class 얻기
        let cls = $(e.target).attr('class');
        // cd effect 효과
        $("#cd").animate({width: "0px"}, "slow", () => {
            // cd 이미지 변경
            $("#cd").attr("class", cls);
            // 너비 다시 300으로
            $("#cd").animate({width: "300px"}, "slow");
        });

        // 노래목록 slideUp
        $("ul.musicList").slideUp('slow');
    });
});