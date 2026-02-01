<?php
$text = $_POST['text'];

$data = json_encode([
    "text" => $text
]);

$ch = curl_init("http://localhost:8080/translator/api/translate");
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    "Content-Type: application/json"
]);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

$response = curl_exec($ch);
curl_close($ch);

$result = json_decode($response, true);
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>

<div class="container">
    <h2>Translation Result</h2>

    <p><b>Original:</b><br><?= htmlspecialchars($result['original']) ?></p>

    <div class="result">
        <b>Darija:</b><br>
        <?= htmlspecialchars($result['translated']) ?>
    </div>

    <br>
    <a href="index.php">⬅ Back</a>
</div>

</body>
</html>
