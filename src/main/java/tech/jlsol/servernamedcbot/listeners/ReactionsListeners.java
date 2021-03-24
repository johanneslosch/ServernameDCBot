package tech.jlsol.servernamedcbot.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONObject;
import tech.jlsol.servernamedcbot.listeners.util.ReactionAddHandler;
import tech.jlsol.servernamedcbot.listeners.util.ReactionRemoveHandler;
import tech.jlsol.servernamedcbot.util.WriteFile;

public class ReactionsListeners extends ListenerAdapter {

  String[] emotes = new String[] {
    "RE:U+1f600",
    "RE:U+1f603",
    "RE:U+1f604",
    "RE:U+1f601",
    "RE:U+1f606",
    "RE:U+1f609",
    "RE:U+1f61d",
    "RE:U+1f60f",
    "RE:U+1f612",
    "RE:U+1f62b",
    "RE:U+2639U+fe0f",
    "RE:U+1f615",
    "RE:U+1f61f",
    "RE:U+1f9d0",
    "RE:U+1f617",
    "RE:U+1f619",
    "RE:U+1f929",
    "RE:U+1f61e",
    "RE:U+1f629",
    "RE:U+1f636",
  };

  private void writeToFile(String content) {
    WriteFile.writer("data", "msg", "txt", content);
  }

  public void onGuildMessageReactionAdd(
    @Nonnull GuildMessageReactionAddEvent event
  ) {
    String emote = event.getReaction().getReactionEmote().toString();
    List<String> list = Arrays.asList(emotes);

    if (list.contains(emote)) {
      if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("init"))
      ) {
        ReactionAddHandler.controlReactionInitM(
          event,
          emote,
          getRole("interest")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("politic"))
      ) {
        ReactionAddHandler.controlReactionPolitic(
          event,
          emote,
          getRole("interestPolitic")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("games"))
      ) {
        ReactionAddHandler.controlReactionGames(
          event,
          emote,
          getRole("interestGames")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("culture"))
      ) {
        ReactionAddHandler.controlReactionCulture(
          event,
          emote,
          getRole("interestCulture")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("development"))
      ) {
        ReactionAddHandler.controlReactionDevelopment(
          event,
          emote,
          getRole("interestDevelopment")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("creators"))
      ) {
        ReactionAddHandler.controlReactionCreators(
          event,
          emote,
          getRole("interestCreators")
        );
      } else if (
        event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("art"))
      ) {
        ReactionAddHandler.controlReactionArt(
          event,
          emote,
          getRole("interestArt")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("science"))
      ) {
        ReactionAddHandler.controlReactionScience(
          event,
          emote,
          getRole("interestScience")
        );
      }
    }
  }

  public void onGuildMessageReactionRemove(
    @Nonnull GuildMessageReactionRemoveEvent event
  ) {
    String emote = event.getReaction().getReactionEmote().toString();
    List<String> list = Arrays.asList(emotes);

    if (list.contains(emote)) {
      if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("init"))
      ) {
        ReactionRemoveHandler.controlReactionInitM(
          event,
          emote,
          getRole("interest")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("politic"))
      ) {
        ReactionRemoveHandler.controlReactionPolitic(
          event,
          emote,
          getRole("interestPolitic")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("games"))
      ) {
        ReactionRemoveHandler.controlReactionGames(
          event,
          emote,
          getRole("interestGames")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("culture"))
      ) {
        ReactionRemoveHandler.controlReactionCulture(
          event,
          emote,
          getRole("interestCulture")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("development"))
      ) {
        ReactionRemoveHandler.controlReactionDevelopment(
          event,
          emote,
          getRole("interestDevelopment")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("creators"))
      ) {
        ReactionRemoveHandler.controlReactionCreators(
          event,
          emote,
          getRole("interestCreators")
        );
      } else if (
        event.getMessageId().equals(Objects.requireNonNull(getMsg()).get("art"))
      ) {
        ReactionRemoveHandler.controlReactionArt(
          event,
          emote,
          getRole("interestArt")
        );
      } else if (
        event
          .getMessageId()
          .equals(Objects.requireNonNull(getMsg()).get("science"))
      ) {
        ReactionRemoveHandler.controlReactionScience(
          event,
          emote,
          getRole("interestScience")
        );
      }
    }
  }

  public static JSONObject getMsg() {
    File file = new File("./data/msg.json");
    String content;
    try {
      content = Files.readString(Path.of(file.toURI()));
      return new JSONObject(content).getJSONObject("messages");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static JSONObject getRole(String object) {
    File file = new File("./data/roles.json");
    String content;
    try {
      content = Files.readString(Path.of(file.toURI()));
      return new JSONObject(content).getJSONObject(object);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
