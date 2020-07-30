package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.listeners.util.ReactionHandler;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.WriteFile;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReactionsListeners extends ListenerAdapter {
    private void writeToFile(String content){
        WriteFile.writer("data", "msg", "txt", content);
    }
    /*
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        System.out.println(event.getReaction().retrieveUsers().complete().get(event.getReaction().retrieveUsers().complete().size()-1).getAsTag());
        Config.writeConfig("data", "reactionUser", event.getGuild().getId() + event.getChannel().getId() + event.getMessageId() + event.getReaction().getReactionEmote().getName(), Arrays.toString(event.getReaction().retrieveUsers().complete().toArray()));
        writeToFile(String.format("REACTION ADDED %s - %s - %s\n", Objects.requireNonNull(event.getReaction().getGuild()).getId(), event.getReaction().getChannel().getId(), event.getReaction().getReactionEmote().getName()));
    }
     */
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        String emote = event.getReaction().getReactionEmote().toString();
        /*
        "RE:U+1f600", "RE:U+1f603", "RE:U+1f604", "RE:U+1f601", "RE:U+1f606", "RE:U+1f609", "RE:U+1f61d", "RE:U+1f60f", "RE:U+1f612", "RE:U+1f62b", "RE:U+2639U+fe0f", "RE:U+1f615", "RE:U+1f61f", "RE:U+1f9d0", "RE:U+1f617", "RE:U+1f619", "RE:U+1f929", "RE:U+1f61e", "RE:U+1f629", "RE:U+1f636"
         */
        //System.out.println(event.getReaction().retrieveUsers().complete().get(event.getReaction().retrieveUsers().complete().size()-1).getAsTag());
        Config.writeConfig("data", "reactionUser", event.getGuild().getId() + event.getChannel().getId() + event.getMessageId() + event.getReaction().getReactionEmote().getName(), Arrays.toString(event.getReaction().retrieveUsers().complete().toArray()));
        writeToFile(String.format("REACTION ADDED %s - %s - %s\n", Objects.requireNonNull(event.getReaction().getGuild()).getId(), event.getReaction().getChannel().getId(), emote));
        String[] emotes = new String[]{"RE:U+1f600", "RE:U+1f603",
                "RE:U+1f604", "RE:U+1f601", "RE:U+1f606", "RE:U+1f609",
                "RE:U+1f61d", "RE:U+1f60f", "RE:U+1f612", "RE:U+1f62b",
                "RE:U+2639U+fe0f", "RE:U+1f615", "RE:U+1f61f", "RE:U+1f9d0",
                "RE:U+1f617", "RE:U+1f619", "RE:U+1f929", "RE:U+1f61e",
                "RE:U+1f629", "RE:U+1f636"};
        List<String> list = Arrays.asList(emotes);

        if(list.contains(emote)){
            System.out.printf("Emote: %s is member of list%n", emote);
            switch (emote){
                case "RE:U+1f600": {
                    event.getChannel().sendMessage("f").queue();
                    break;
                }
                case "RE:U+1f603": {
                    break;
                }
                case "RE:U+1f604": {
                    break;
                }
                case "RE:U+1f601": {
                    break;
                }
                case "RE:U+1f606": {
                    break;
                }
                case "RE:U+1f609": {
                    break;
                }
                case "RE:U+1f61d": {
                    break;
                }
                case "RE:U+1f60f": {
                    break;
                }
                case "RE:U+1f612": {
                    break;
                }
                case "RE:U+1f62b": {
                    break;
                }
                case "RE:U+2639U+fe0f": {
                    break;
                }
                case "RE:U+1f615": {
                    break;
                }
                case "RE:U+1f61f": {
                    break;
                }
                case "RE:U+1f9d0": {
                    break;
                }
                case "RE:U+1f617": {
                    break;
                }
                case "RE:U+1f619": {
                    break;
                }
                case "RE:U+1f929": {
                    break;
                }
                case "RE:U+1f61e": {
                    break;
                }
                case "RE:U+1f629": {
                    break;
                }
                case "RE:U+1f636": {
                    break;
                }

            }
        }
    }
}
/*
// this works for up to 10 elements:
Map<String, String> test1 = Map.of(
    "a", "b",
    "c", "d"
);
if (test1.containsKey(emote)) {
    test1.get(emote)
}
 */
