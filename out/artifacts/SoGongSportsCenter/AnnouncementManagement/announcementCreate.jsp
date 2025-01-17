<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>소공 체육 센터</title>
        <meta name="viewport" content="width=device-width", initial-scale="1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/announcement.css?ver=1">
    </head>
</head>
<body>
    <div class="header">
        <div class="logo"><h1>소공 체육 센터</h1></div>
    </div>

    <div class="nav-bar">
        <ul>
            <li><a href="/main.jsp">Home</a></li>
            <li class="dropdown">
                <a href="#" class="dropbtn">회원 관리</a>
                <div class="dropdown-content">
                    <a href="#">회원 등록</a>
                    <a href="#">회원 조회</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">강사 관리</a>
                <div class="dropdown-content">
                    <a href="#">강사 등록</a>
                    <a href="#">강사 조회</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">강습 관리</a>
                <div class="dropdown-content">
                    <a href="#">강습 등록</a>
                    <a href="#">수강 신청</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">공지사항</a>
                <div class="dropdown-content">
                    <a href="announcementCreate.jsp">공지 등록</a>
                    <a href="announcementList.jsp">공지 조회</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">사물함 관리</a>
                <div class="dropdown-content">
                    <a href="#">사물함 생성</a>
                    <a href="#">사물함 신청</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbtn">매출 조회</a>
                <div class="dropdown-content">
                    <a href="#">기간별 매출 조회</a>
                    <a href="#">강습별 매출 조회</a>
                </div>
            </li>
        </ul>
    </div>

    <div class="container">
        <div class="row">
            <form method="post" action="announcementCreateView.jsp">
                <table class="table" style="text-align: center; border: 1px solid #dddddd">

                    <thead>
                    <tr>
                        <th colspan="2" style="background-color: #eeeeee; text-align: center;">공지사항 작성</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td><input type="text" class="input" placeholder="글 제목" name="announcementTitle" maxlength="45"></td>
                    </tr>
                    <tr>
                        <td><input type="file" class="input" name="attachedFile"> </td>
                    </tr>
                    <tr>
                        <td><textarea class="input" placeholder="글 내용" name="announcementContent" maxlength="10000" style="height: 350px"></textarea></td>
                    </tr>
                    </tbody>

                </table>
                <input type="submit" href="announcementList.jsp" class="inputBtn" value="등록">
            </form>
        </div>
    </div>
</body>
</html>
