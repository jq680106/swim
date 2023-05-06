import random
import webbrowser
bot_template = "Ben : {0}"
user_template = "USER: {0}"

responses = {
    "hi": "Hello!",
    "joke": "Teacher: Did your father help you with your homework?  \n No. he did it all by himself.",
    "how are you": "I'm doing great, thank you!",
    "what's your name": "My name is Ben!",
    "default": "I'm sorry, I didn't understand what you said. Can you please repeat that?",
    "website": "wait a minute!!"
}
def respond(message):
    if message.lower() in responses:
        return bot_template.format(responses[message.lower()])
    else:
        return bot_template.format(responses["default"])
def respond(message):
    if message in responses:
        if message == "website":
            webbrowser.open("https://www.yahoo.com.tw")
            return bot_template.format(responses[message])
        else:
            return bot_template.format(responses[message])
    else:
        return bot_template.format(responses["default"])

def chat():
    print("Welcome to the chatbot! Start talking to me by typing a message.")
    while True:
        user_message = input(user_template.format(""))
        if user_message.lower() == "exit":
            print(bot_template.format("Goodbye!"))
            break
        bot_message = respond(user_message)
        print(bot_message)


chat()
