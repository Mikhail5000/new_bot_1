require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        q!: * (привет/здравствуй*/~добрый (~утро/~вечер/~день/~ночь)/hello/hi) *
        random:
            a: Привет!
            a: Здравствуйте!
            a: Добрый день!
        
    state: Weather
        intent!: /погода
        q!: * (погода/weather/на улице) *
        random:
            a: Сегодня облачно, возможны осадки в виде фрикаделек
            a: Хорошая погода

    state: Currency
        intent!: /курс валют
        q!: * (валют/курс/currency) *
        random:
            a: На рынке все хорошо! Доллар и Евро ниже 100
            a: На рынке стабильно

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: Я понял. Вы сказали: {{$context.intent.answer}}