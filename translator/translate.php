<?php

$text = $_POST['text'] ?? '';

if (!$text) {
    header("Location: index.php");
    exit;
}

$ch = curl_init("http://localhost:8080/translator/api/translate");

curl_setopt_array($ch, [
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_POST => true,
    CURLOPT_HTTPHEADER => [
        "Content-Type: application/json",
        "Authorization: Basic " . base64_encode("admin:admin1312")
    ],
    CURLOPT_POSTFIELDS => json_encode([
        "text" => $text
    ])
]);

$response = curl_exec($ch);
$httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

$translated = "Erreur serveur";

if ($httpCode === 200 && $response) {
    $data = json_decode($response, true);
    if (isset($data['translated'])) {
        $translated = $data['translated'];
    }
}

header("Location: index.php?translated=" . urlencode($translated));
exit;

