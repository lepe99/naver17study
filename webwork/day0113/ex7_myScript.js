// 웹 페이지의 모든 리소스가 로드된 후 실행될 코드 정의
window.onload = (e) => {
    let myCar = document.querySelectorAll(".myCar");//배열타입

    // 0번 이미지 이벤트
    // 마우스를 올리면 ../photo/K-052.png 로 변경하고 벗어나면 다시 원래 이미지로 변경
    let photo = "";
    myCar[0].onmouseover = (e) => {
        photo = e.target.getAttribute("src");
        e.target.setAttribute("src", "../photo/K-052.png");
    }
    myCar[0].onmouseout = (e) => {
        e.target.setAttribute("src", photo);
    }

    // 1번 이미지 이벤트
    // 마우스를 올리면 border 를 알아서 설정하고 벗어나면 다시 없애기
    myCar[1].onmouseover = (e) => {
        e.target.style.borderStyle = "inset";
        e.target.style.borderWidth = "10px";
        e.target.style.borderColor = "green";
    }
    myCar[1].onmouseout = (e) => {
        e.target.style.border = "none";
    }

    // 2번 이미지 이벤트
    // 마우스를 올리면 .happy 를 적용하고 벗어나면 다시 없애기
    // .happy 는 미리 만들어둘 것 (내용 상관없음)
    myCar[2].onmouseover = (e) => {
        e.target.setAttribute("class", "myCar happy");
    }
    myCar[2].onmouseout = (e) => {
        e.target.setAttribute("class", "myCar");
    }
}
