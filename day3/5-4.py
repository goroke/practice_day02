# 5.4, 5.5

letter = '\tDear {salutation} {name},\n' \
'\tThank you for your letter. ' \
'We are sorry that our {product} {verbed} in your {room}. ' \
'Please note that it should never be used in a {room}, ' \
'especially near any {animals}.\n\n' \
'\tSend us your receipt and {amount} for shipping and handling. ' \
'We will send you another {product} that, ' \
'in our tests, is {percent}% less likely to have {verbed}.\n\n' \
'\tThank you for your support.\n' \
'\tSincerely,\n\t{spokesman}\n\t{job_title}'

print(letter.format(salutation='the president',
                    name='Joe Biden',
                    product='spaceship',
                    verbed='exploded',
                    room='dinning room',
                    animals='guests',
                    amount='$45,000,000',
                    percent=0.001,
                    spokesman='Elon Musk',
                    job_title='Techno King'))

