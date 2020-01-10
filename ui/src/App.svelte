<script>
    import TopAppBar, {Row, Section, Title} from '@smui/top-app-bar';
    import Drawer, {AppContent, Scrim} from '@smui/drawer';
    import List, {Item, Text, Separator} from '@smui/list';
    import Button, {Label} from '@smui/button';
    import IconButton from '@smui/icon-button';
    import Router from 'svelte-spa-router';

    import Home from './routes/Home.svelte';
    import LoremIpsum from './routes/LoremIpsum.svelte';

    const routes = {
        '/': Home,
        '/loremIpsum': LoremIpsum,
        '*': Home,
    };

    let drawer;
    let drawerOpen = false;
</script>

<style>
    .drawer-container {
        padding-top: 64px;
        height: 100%;
    }

    .app-content {
        overflow-y: auto;
        height: 100%;
    }
</style>

<TopAppBar variant="fixed" class="top-app-bar">
    <Row>
        <Section>
            <IconButton class="material-icons" on:click={() => drawerOpen = !drawerOpen}>menu</IconButton>
            <Title>Svelte Starter</Title>
        </Section>
        <Section align="end" toolbar>
            <Button aria-label="fjåge" href="https://github.com/org-arl/fjage" target="_blank" variant="raised">
                <Label>fjåge</Label>
            </Button>
        </Section>
    </Row>
</TopAppBar>

<div class="drawer-container">
    <Drawer variant="modal" bind:this={drawer} bind:open={drawerOpen}>
        <List>
            <Item href="#/" on:click={() => drawerOpen = false}>
                <Text>Chat</Text>
            </Item>
            <Item href="#/loremIpsum" on:click={() => drawerOpen = false}>
                <Text>LoremIpsum</Text>
            </Item>
            <Separator nav/>
        </List>
    </Drawer>

    <Scrim/>

    <AppContent>
        <div class="app-content">
            <Router {routes}/>
        </div>
    </AppContent>
</div>
