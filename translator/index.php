<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>English → Darija Translator</title>
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>

<div class="container">
    <h2>English → Darija Translator 🇲🇦</h2>

    <form method="post" action="translate.php">
        <textarea name="text" placeholder="Enter English text" required></textarea>
        <button type="submit">Translate</button>
    </form>

    <?php if (isset($_GET['translated'])): ?>
        <div class="result">
            <strong>Darija:</strong><br>
            <?= htmlspecialchars($_GET['translated']) ?>
        </div>
    <?php endif; ?>
</div>

</body>
</html>