<script>
    import Textfield from '@smui/textfield';
    import Button, {Label} from '@smui/button';
    import Chip, {Text} from '@smui/chips';
    import {Gateway} from '../lib/fjage';
    import {TestRequest} from '../lib/testService';

    // ----

    let testAgentId = null;

    let value1 = 0;
    let value2 = 0;
    let result = value1 * value2;
    let message = '';

    function newGateway() {
        if (window.location.search === '?dev') {
            return new Gateway('localhost', 8888);
        } else {
            return new Gateway();
        }
    }

    const gateway = newGateway();
    //gateway.debug = true;
    gateway.addConnListener(function (connected) {
        if (connected) {
            gateway.agentForService('TEST')
                    .then((aid) => {
                        if (aid) {
                            testAgentId = aid;
                            gateway.subscribe(testAgentId);
                        }
                    })
                    .catch(ex => {
                        console.warn('Could not find TEST Agent: ' + ex);
                    });
            gateway.addMessageListener(function (msg) {
                if (msg.__clazz__ === 'TestNotification') {
                    message = msg.message;
                }
            });
        }
    });

    function send() {
        const testRequest = new TestRequest();
        testRequest.recipient = testAgentId;
        testRequest.value1 = value1;
        testRequest.value2 = value2;
        gateway.request(testRequest, 5000)
                .then(function (testResponse) {
                    result = testResponse.value;
                });
    }
</script>

<div class="container">
    <div>
        <div class="input-container">
            <Textfield
                    bind:value={value1}
                    class="shaped-outlined"
                    variant="outlined"
                    label="Value 1"
            />
            <span>&nbsp;</span>
            <Chip>
                <Text>x</Text>
            </Chip>
            <span>&nbsp;</span>
            <Textfield
                    bind:value={value2}
                    class="shaped-outlined"
                    variant="outlined"
                    label="Value 2"
            />
            <span>&nbsp;</span>
            <Button variant="raised" on:click={send}><Label>=</Label></Button>
            <span>&nbsp;</span>
            <Textfield
                    bind:value={result}
                    class="shaped-outlined"
                    variant="outlined"
                    label="Result"
            />
        </div>
    </div>
    <div class="message-container">
        {message}
    </div>
</div>

<style>
    .container {
        margin: 2em;
    }

    .input-container {
        vertical-align: middle;
    }

    .message-container {
        padding: 1em;
    }
</style>
