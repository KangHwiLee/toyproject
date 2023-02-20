const form = document.getElementById('chat-form');
const messageInput = document.getElementById('message-input');
const chatLog = document.getElementById('chat-log');

form.addEventListener('submit', async (event) => {
  event.preventDefault();

  const message = messageInput.value;
  if (!message) {
    return;
  }

  const response = await getChatResponse(message);
  console.log(response)
  const chatEntry = document.createElement('div');
  chatEntry.innerText = `You: ${message}``
  const AIArea = document.createElement('div');
  AIArea.innterText = `Chatbot:${response}`

  chatEntry.innerText = `You: ${message}\nChatbot: ${response}`;
  console.log(chatEntry);
  chatLog.appendChild(chatEntry);

  messageInput.value = '';
});

async function getChatResponse(message) {
  const apiKey = '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';
  const apiUrl = 'https://api.openai.com/v1/engines/davinci-codex/completions';
  const data = JSON.stringify({
    prompt: `Human: ${message}\nAI:`,
    max_tokens: 100,
    temperature: 0.7
  });

  const response = await fetch(apiUrl, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${apiKey}`
    },
    body: data
  });

  const json = await response.json();
  const chatResponse = json.choices[0].text.trim();
  return chatResponse;
}
