let sidebarVisible = false;
let sidebar;

function createSidebar() {
  sidebar = document.createElement("div");
  sidebar.id = "darija-sidebar";

  sidebar.innerHTML = `
    <header>Translate to Darija</header>

    <textarea id="inputText" placeholder="Select or paste text..."></textarea>

    <button id="translateBtn">Translate</button>

    <div id="result"></div>

    <footer>Powered by Spakalw1312</footer>
  `;

  document.body.appendChild(sidebar);
  document.body.classList.add("darija-active");

  // Auto-fill selected text
  document.addEventListener("mouseup", () => {
    const selected = window.getSelection().toString().trim();
    if (selected) {
      document.getElementById("inputText").value = selected;
    }
  });

  document.getElementById("translateBtn").onclick = () => {
    const text = document.getElementById("inputText").value.trim();
    if (!text) return;

    document.getElementById("result").innerText = "Translating...";

    chrome.runtime.sendMessage(
      { action: "translate", text },
      (response) => {
        if (!response || !response.success) {
          document.getElementById("result").innerText =
            response?.error || "Erreur serveur";
          return;
        }

        document.getElementById("result").innerText =
          response.data.translated;
      }
    );
  };
}

chrome.runtime.onMessage.addListener((msg) => {
  if (msg.action === "toggleSidebar") {
    if (!sidebar) {
      createSidebar();
      sidebarVisible = true;
    } else {
      sidebarVisible = !sidebarVisible;
      sidebar.style.display = sidebarVisible ? "flex" : "none";
      document.body.classList.toggle("darija-active", sidebarVisible);
    }
  }
});

console.log("content.js injected");
