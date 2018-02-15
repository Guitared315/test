<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <title>4eachblog　掲示板</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

    <?php

mb_internal_encoding("utf8");
$pdo = new PDO("mysql:dbname=lesosn01;host=localhost;","root","maysql");

$stmt = $pdo->query("select * from 4each_keijiban");

while($row = $stmt->fetch()){
echo $row['name'];
echo $row['title'];
echo $row['comments'];
};
?>

        <header>
            <img src="4eachblog_logo.jpg" class="logoimg">
            <div class="menu">
                <ul>
                    <li>トップ</li>
                    <li>プロフィール</li>
                    <li>4eachについて</li>
                    <li>登録フォーム</li>
                    <li>お問い合わせ</li>
                    <li>その他</li>
                </ul>
            </div>
        </header>

        <main>
            <div class="left">
                <h1>プログラミングに役立つ掲示板</h1>
                <div class="input flame">
                    <form method="post" action="insert.php">
                        <div class="form">
                            <div class="border">入力フォーム</div>
                        </div>
                        <div class="inputc">ハンドルネーム<br>
                            <input type="text" name="name">
                        </div>
                        <div class="inputc">タイトル<br>
                            <input type="text" name="title">
                        </div>
                        <div class="inputc">コメント<br>
                            <textarea rows="6" cols="40" name="comments"></textarea></div>
                        <div class="inputc">
                            <input type="submit" value="送信する"></div>
                    </form>

                </div>

                <div class="keiji">
                    <div class="flame">
                        <div class="title">
                            タイトル</div>
                        <div class="kiji">
                            <script>
                                function kiji() {
                                    document.write("記事の内容");
                                    for (var i = 0; i < 20; i++) {
                                        document.write(",記事の内容");
                                    }
                                }

                                kiji();

                            </script>
                        </div>

                        <div class="posted">posted by 通りすがり</div>
                    </div>
                </div>
                <div class="keiji">
                    <div class="flame">
                        <div class="title">タイトル</div>
                        <div class="kiji">
                            <script>
                                kiji();

                            </script>
                        </div>
                        <div class="posted">posted by 通りすがり</div>
                    </div>
                </div>

            </div>

            <div class="right">
                <ul>
                    <div class="popnews">人気の記事</div>
                    <li>PHPオススメ本</li>
                    <li>PHP MyAdminの使い方</li>
                    <li>いま人気のエディタTop5</li>
                    <li>HTMLの基礎</li>
                </ul>
                <ul>
                    <div class="popnews">オススメリンク</div>
                    <li>インターノウス株式会社</li>
                    <li>XAMPPのダウンロード</li>
                    <li>Eclipseのダウンロード</li>
                    <li>Braketsのダウンロード</li>
                </ul>
                <ul>
                    <div class="popnews">カテゴリ</div>
                    <li>HTML</li>
                    <li>PHP</li>
                    <li>MySQL</li>
                    <li>JavaScript</li>
                </ul>
            </div>



        </main>

        <footer>
            <div id="footer">copyright internous | 4each blog is the one which provides A to Z about programming.</div>
        </footer>
</body>

</html>
