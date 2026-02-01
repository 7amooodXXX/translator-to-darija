// ====== 1️⃣ OUVERTURE / FERMETURE SIDEBAR ======
chrome.action.onClicked.addListener((tab) => {
  if (!tab.id) return;

  chrome.tabs.sendMessage(tab.id, {
    action: "toggleSidebar"
  });
});

// ====== 2️⃣ TRADUCTION ======
chrome.runtime.onMessage.addListener((msg, sender, sendResponse) => {
  if (msg.action === "translate") {

    const username = "admin";
    const password = "admin1312";
    const credentials = btoa(username + ":" + password);

    fetch("http://localhost:8080/translator/api/translate", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": "Basic " + credentials
      },
      body: JSON.stringify({ text: msg.text })
    })
      .then(res => {
        if (res.status === 401) {
          throw new Error("AUTH_REQUIRED");
        }
        return res.json();
      })
      .then(data => {
        sendResponse({ success: true, data });
      })
      .catch(err => {
        if (err.message === "AUTH_REQUIRED") {
          sendResponse({
            success: false,
            error: "🔐 Vous devez vous authentifier"
          });
        } else {
          sendResponse({
            success: false,
            error: "Erreur serveur"
          });
        }
      });

    return true; // obligatoire pour réponse async
  }
});
