require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: hello
        intent!: /hello
        q!: * (привет/здравствуй*/~добрый (~утро/~вечер/~день/~ночь)/hello/hi) *
        random: 
            a: Привет!
            a: Здравствуйте!
            a: Добрый день!

    state: weather
        intent!: /weather
        q!: * (погод*/weather/на улице/дождь) *
        random: 
            a: Сегодня облачно, возможны осадки в виде фрикаделек
            a: Хорошая погода

    state: currency
        intent!: /currency
        q!: * (валют*/курс/currency/доллар*/рубл*) *
        random: 
            a: На рынке все хорошо! Доллар и Евро ниже 100
            a: На рынке стабильно

    state: NoMatch
        intent: /NoMatch
        q!: *
        #event!: noMatch
        random:
            a: Я не понял. Вы сказали: {{$request.query}}
            a: Увы, я не понимаю. Вы сказали: {{$request.query}}