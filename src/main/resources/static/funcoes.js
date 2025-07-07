async function colarLink() {
    try {
        const linkCopiado = await navigator.clipboard.readText();
        document.getElementById('link').value = linkCopiado;
    } catch (error) {
        console.log("Falha ao colar o link copiado", error);
        alert("Não foi possível colar o link. Por favor, cole manualmente ou verifique as permissões do navegador.");
    }
}

async function copiarLink() {
    try {
        const linkencurtado = document.getElementById("url").textContent;
        await navigator.clipboard.writeText(linkencurtado);
        alert("Link copiado com sucesso!");
    } catch (error) {
        console.log("Falha ao copiar o link encurtado", error);
        alert("Não foi possível copiar o link. Por favor, copie manualmente.");
    }
}

function encurtarLink() {
    const linkInput = document.getElementById('link');
    const link = linkInput.value.trim();

    const urlRegex = /^(ftp|http|https):\/\/[^ "]+$/;
    if (!link) {
        alert("Por favor, insira um link para encurtar.");
        return;
    }
    if (!urlRegex.test(link)) {
        alert("Por favor, insira um link válido (ex: http://www.exemplo.com).");
        return;
    }

    const linkEncurtadoDiv = document.getElementById('link-encurtado');
    const urlParagraph = document.getElementById('url');
    const btnCopiar = document.getElementById('copiar-link');

    linkEncurtadoDiv.style.display = "none";
    urlParagraph.innerText = "";
    urlParagraph.style.display = "none";
    btnCopiar.style.display = "none";

    axios.get('/api/link?link=' + encodeURIComponent(link))
        .then(function (response) {
            const linkEncurtado = response.data;

            urlParagraph.innerText = linkEncurtado;

            urlParagraph.style.display = "block";
            btnCopiar.style.display = "inline-block";
            linkEncurtadoDiv.style.display = "flex";

        })
        .catch(function (error) {
            console.error("Erro ao encurtar o link:", error.response ? error.response.data : error.message);
            alert("Ocorreu um erro ao encurtar o link. Por favor, verifique a URL e tente novamente.");
            linkEncurtadoDiv.style.display = "none";
        })
        .finally(function () {
            linkInput.value = "";
        });
}