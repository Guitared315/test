<!DOCTYPE>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <title>お問い合わせフォーム</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <h1>お問い合わせフォーム</h1>
    <form method="post" action="mail_confirm.php">
        <div>
            <label>お名前</label>
            <br>
            <input type="text" name="name" size="25" class="input" />
        </div>
        <div>メールアドレス
            <br>
            <input type="text" name="mail" placeholder="xxx@yyy.com" size="40" class="input" /></div>

        <div>年齢<br>
            <select name="age" class="input">
        <option >選択してください</option>
            <script>
            for(var i = 18; i <= 65; i++){
            document.write("<option>" + i + "</option>");
                

            }</script>
                
        </select> 歳
        </div>
        <div>コメント<br>

            <textarea rows="10" name="comments" cols="50" class="input"></textarea>
        </div>
        <div>
            <input type="submit" value="送信する" class=" submit ">
        </div>
    </form>
</body>

</html>
